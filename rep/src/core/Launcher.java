package core;

import simulation.*;

public class Launcher {

	public static void main(String[] args) {
		int n=20;	//エージェント数;
		int n0=20;	//初期エージェント数
		int edge=19;	//エージェントあたりのエッヂ数
		Simulation.start(Seed._seeds[0],n,n0,edge);
	}
}
