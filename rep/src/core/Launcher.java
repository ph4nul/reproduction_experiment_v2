package core;

import simulation.*;

public class Launcher {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int n=20;	//エージェント数;
		int n0=20;	//初期エージェント数
		int edge=19;	//エージェントあたりのエッヂ数
		Simulation.start(Seed._seeds[2],n,n0,edge);
		long endTime = System.currentTimeMillis();
		System.out.println("time：" + ((endTime - startTime)/1000) + " s");
	}
}
