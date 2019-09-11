package simulation;

import agent.*;
import core.*;
import general_metanorms_game.*;
import network.*;
import random.*;
import genetic_algorithm.*;

public class Simulation {
	public static void start(int seed_num,int n,int n0,int edge) {
		//Sfmt rnd= new Sfmt(seed_num);
		MakeRnd rnd=new MakeRnd(seed_num);
		int times=10000;	//シミュレーション回数
		Agent[] agents=new Agent[n];
		
		//Create Agents
		for(int i=0;i<n;i++) {
			agents[i]=new Agent(i);
			agents[i].createGene(rnd);
			agents[i].showBits(i);
		}
		
		System.out.println("--------------------");
		
		for(int i=0;i<n;i++) {
			System.out.println("B="+agents[i].getAgentValueBV(0)+",V="+agents[i].getAgentValueBV(1)+",L="+agents[i].getAgentValueBL(1));
		}
		System.out.println("--------------------");
		
		for(int i=0;i<n;i++) {
			System.out.print("Agent"+i+"_BV ");
			for(int j=0;j<6;j++) {
				System.out.print(agents[i].getBV(j));
			}
			System.out.println();
		}
		System.out.println("--------------------");
		
		for(int i=0;i<n;i++) {
			System.out.print("Agent"+i+"_BL ");
			for(int j=0;j<6;j++) {
				System.out.print(agents[i].getBL(j));
			}
			System.out.println();
		}
		System.out.println("--------------------");
		
		//PrintInitialSstate.export(n,agents);
		
		CompleteGraph cg=new CompleteGraph(agents,n,n0,edge,rnd);
		cg.CompleteGraphModel();
		System.out.println("Making network completed.");
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		
		CalculationBVL.SetHeader();
		//MetaPunishment punishment =new MetaPunishment(n,3.0,-1.0,-9.0,-2.0,-9.0,-2.0); 
		MetaReward reward =new MetaReward(n,-3.0,1.0,-2.0,9.0,-2.0,9.0); 
		for(int i=0;i<times;i++) {
			
			
			//punishment.game(i,agents,rnd);
			reward.game(i,agents,rnd);
			
			UniformCrossover uc=new UniformCrossover(n);
			//UniformCrossoverReward ucr=new UniformCrossoverReward(n);
			uc.ga(i,agents,rnd);
			//ucr.ga(i,agents,rnd);
			CalculationBVL.Export(agents,n,i);

			for(int j=0;j<n;j++) {
				agents[j].resetScore();
				agents[j].printBL();
			}
			System.out.println("finish step"+i);
		}
	}
	
}
