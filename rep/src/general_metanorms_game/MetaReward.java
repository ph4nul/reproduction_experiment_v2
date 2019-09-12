package general_metanorms_game;

import agent.Agent;
import random.*;

public class MetaReward {

	int n;	//�G�[�W�F���g��
	double F;	//�G�[�W�F���gi�����؂�������i�̓��闘��
	double M;	//�c��̃G�[�W�F���g�����闘��
	double C;	//j��i�̗��؂�𔭌����������Ƃ���i�̓��闘��
	double R;	//j��i�̗��؂�𔭌����������Ƃ���j�̓��闘��
	double CC;	//����ɁAj��i�̗��؂�𔭌����Aj��i�𔱂��Ȃ��������Ƃ�k��j�𔱂����Ƃ���j�̓��闘��
	double RR;	//����ɁAj��i�̗��؂�𔭌����Aj��i�𔱂��Ȃ��������Ƃ�k��j�𔱂����Ƃ���k�̓��闘��
	
	public MetaReward(int num,double f,double m,double c,double r,double cc,double rr) {
		n=num;
		F=f;	
		M=m;	
		C=c;	
		R=r;	
		CC=cc;	
		RR=rr;
	}
	
	private void checkCoordination(int times,Agent[] agents,MakeRnd rnd) {
		for(int i=0;i<n;i++) {
			PrintStateOfGame.writeAgent(i,times, agents);
			double S=agents[i].getS();
			//System.out.println(agents[i].getS());
			if(S<agents[i].getAgentValueBL(0)/7.0) {	//����	
				PrintStateOfGame.writeCoordination(i,times, agents);
				for(int j=0;j<n;j++) {
					if(j==i) agents[j].addScore(F);
					else agents[j].addScore(M);
				}
				CheckOthers1(times,"Phase2",i,S,agents,rnd);
			}
			else {	//���؂�
				PrintStateOfGame.writeBetrayal(i,times, agents);
			}
			PrintStateOfGame.writeEnd(times);
			PrintScoreOfGame.writeScore(i,times,n,agents);
		}
		PrintStateOfGame.writeLine(times);
	}
	
	private void CheckOthers1(int times,String name,int i,double S,Agent[] agents,MakeRnd rnd) {
		for(int j=0;j<n;j++) {
			double rnd1=rnd.getRandomNumber();
			double rnd2=rnd.getRandomNumber();
			
			if(i==j) {
				continue;
			}
			
			if(rnd1<S) {	//���e�ɋC�Â���
				PrintStateOfGame.writeFind(i,j,times,agents);
				if(rnd2<(agents[j].getAgentValueBL(1)/7.0)) {	//�R�����g����
					agents[j].addScore(C);
					agents[i].addScore(R);
					PrintStateOfGame.writeComment(i,j,times,agents);
					CheckOthers2(times,"Phase3",i,j,S,agents,rnd);
					
				}
				else {	//�R�����g���Ȃ�
					PrintStateOfGame.writeNotComment(i,j,times,agents);
				}
			}
			else {	//�C�Â��Ȃ�����
				PrintStateOfGame.writeNotFind(i,j,times,agents);
			}
		}
	}
	
	private void CheckOthers2(int times,String name,int i,int j,double S,Agent[] agents,MakeRnd rnd) {
		for(int k=0;k<n;k++) {
			double rnd1=rnd.getRandomNumber();
			double rnd2=rnd.getRandomNumber();
			
			if(j==k) {
				continue;
			}
				
			if(rnd1<S) {	//�R�����g�ɋC�Â���
				PrintStateOfGame.writeFind2(j,k,times,agents);
				if(rnd2<(agents[k].getAgentValueBL(1)/7.0)) {	//���؂�ɑ΂���w�E
					agents[k].addScore(CC);
					agents[j].addScore(RR);
					PrintStateOfGame.writeMetaComment(j,k,times,agents);
				}
				else {	//�w�E���Ȃ�
					//PrintStateOfGame.writeNotMetaComment(j,k,times,agents);
				}
			}
			else {
				PrintStateOfGame.writeNotFind2(j,k,times,agents);
			}
		}
	}
	
	public void game(int times,Agent[] agents,MakeRnd rnd) {
		PrintStateOfGame.makeFile(times);
		PrintScoreOfGame.makeFile(times,n);
		for(int i=0;i<4;i++) {
			//System.out.println("phase"+i);
			for(int j=0;j<n;j++) {	//�������Z�b�g
				agents[j].setS(rnd);	
				//System.out.println(agents[j].getS());
			}
			//System.out.println("--------------------");
			
			PrintStateOfGame.writeLap(i,times);
			PrintScoreOfGame.writeLap(i,times);
			
			checkCoordination(times,agents,rnd);
		}
	}
	
}
