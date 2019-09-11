package genetic_algorithm;

import agent.Agent;
import random.*;
import java.lang.Double;
import java.util.LinkedHashMap;
import java.util.Map;

class AgentWeight{
	int agent_num;
	double weight;
}

public class UniformCrossover {//完全グラフにしか使えない
	int n;	//agent number
	//double[][] weight=new double[n][2];	//[0=エージェント番号,1=重み]
	//Map<Integer,Double> weight =new HashMap<>();
	private double[] weight;
	private int[][] tmp_child;	//できた子供を格納しておく
	//Agent[] agents;
	
	public UniformCrossover(int num) {
		n=num;
		weight=new double[n];
		tmp_child=new int[n][6];
		//agents=Agent;
		
	}
	
	public void calculateWeight(Agent[] agents) {	
		double v_min=10000000;
		for(int i=0;i<n;i++) {
			if(v_min>agents[i].getScore()) {
				v_min=agents[i].getScore();
			}
		}
		
		for(int i=0;i<n;i++) {
			double v_child=0.0;
			double v_parent=0.0;
			v_child=Math.pow((agents[i].getScore()-v_min), 2);	//重みの計算（エージェントi）
			for(int j=0;j<agents[i].getListSize();j++) {
				v_parent+=Math.pow((agents[agents[i].getAgentNumber(j)].getScore()-v_min), 2);
			}
			//System.out.println(i+" "+v_child+" "+v_parent+" "+v_child/v_parent);
			
			if(Double.compare(v_parent, 0)==0) {
				weight[i]=(double)1/n;
			}
			else {
				weight[i]=v_child;
			}
			//System.out.println(weight[i]);
		}
		//System.out.println(weight);
	}
	
	public int[] weightedLottery(int agent_num,MakeRnd rnd) {
		int[] parent=new int[2];
		for(int i=0;i<2;i++) {
			AgentWeight[] probability=new AgentWeight[n];
			AgentWeight[] new_weight=new AgentWeight[n];
			for(int j=0;j<n;j++) {
				probability[j]=new AgentWeight();
				new_weight[j]=new AgentWeight();
			}
			//double[] probability=new double[n];
			//double[] new_weight=new double[n];
			
			//Map<Integer,Double> new_weight= new LinkedHashMap<>();
			//Map<Integer,Double> probability= new LinkedHashMap<>();
			double total_weight=0.0;
			int cnt=0;
			for(int j=0;j<n;j++) {
				if(weight[j]==0) {
					continue;
				}
				total_weight+=weight[j];
				new_weight[cnt].weight=weight[j];
				new_weight[cnt].agent_num=j;
				cnt++;
			}
			//System.out.println(total_weight);
			for(int j=0;j<cnt;j++) {
				if(j==0) {
					probability[j].weight=new_weight[j].weight/total_weight;
					probability[j].agent_num=new_weight[j].agent_num;
				}
				else{
					probability[j].weight=probability[j-1].weight+new_weight[j].weight/total_weight;
					probability[j].agent_num=new_weight[j].agent_num;
				}
			}
			
			for(int j=0;j<cnt;j++) {
				//System.out.println(probability[j].agent_num+"___"+probability[j].weight);
			}
			
			double r=rnd.getRandomNumber();
			//System.out.println(r);
			for(int j=0;j<n;j++){
				if(weight[j]==0) {
					continue;
				}
	        	if(r<probability[j].weight){
	        		parent[i]=probability[j].agent_num;
	        		weight[probability[j].agent_num]=0;
	        		break;
	        	}
	        }
		}
		
		return parent;
	}
	
	public void evolution(int i,int[] bitmask,int[] num_of_parents,Agent[] agents,MakeRnd rnd) {	
		
		for(int j=0;j<6;j++) {	//懲罰ゲーム用の子供生成
			if(bitmask[j]==1) {
				tmp_child[i][j]=agents[num_of_parents[0]].getBL(j);
			}
			else {
				tmp_child[i][j]=agents[num_of_parents[1]].getBL(j);
			}
			double r = rnd.getRandomNumber();
			if(r<0.01) {
				//System.out.println("mutation!!!");
				if(tmp_child[i][j]==1) tmp_child[i][j]=0;
				else tmp_child[i][j]=1;
			}
		}
	}
	
	public void ga(int times,Agent[] agents,MakeRnd rnd) {
		//PrintEvolution.makeFile(times);
		int[] bitmask=new int[6];	//ビットマスク
		int[] num_of_parents=new int[2];	//選択した親の番号を格納
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<6;j++) {	//マスクのビット列生成
				double bit = rnd.getRandomNumber();
				
				if(bit<0.5) bitmask[j]=0;
				else bitmask[j]=1;
			}
			calculateWeight(agents);
			//System.out.println(weight[1]);
			
			num_of_parents=weightedLottery(i,rnd);

			//System.out.println("agent"+i+" "+num_of_parents[0]+" "+num_of_parents[1]);

				//if(i==0&&j==0) PrintEvolution.writeProbability(times, n, probability, agents);
			
			
			/*calculateWeight2(i,agents);
			for(int j=0;j<2;j++) {	//抽選
				num_of_parents[j]=weightedLottery2(i,rnd);
				if(i==0&&j==0) PrintEvolution.writeProbability(times, n, probability, agents);
			}*/
			
			//System.out.println(num_of_parents[0]+" "+num_of_parents[1]);
			
			
			evolution(i,bitmask,num_of_parents,agents,rnd);
			
			//PrintEvolution.writeEvolution(times,i,num_of_parents,tmp_child,agents);
			
		}
		
		/*for(int i=0;i<n;i++) {
			double r = rnd.getRandomNumber();	//突然変異
			if(r<0.01) {
				System.out.println("mutation!!!");
				for(int j=0;j<6;j++) {
					if(tmp_child[i][j]==1) tmp_child[i][j]=0;
					else tmp_child[i][j]=1;
				}
			}
		}*/
		
		for(int i=0;i<n;i++) {	//進化を反映
			for(int j=0;j<3;j++) {	//懲罰ゲーム用の子供生成
				agents[i].setAgentValueBL(tmp_child[i][j],j);
			}
			for(int j=3;j<6;j++) {	//懲罰ゲーム用の子供生成(続き)
				agents[i].setAgentValueBL(tmp_child[i][j],j);
			}
		}
	}
}
