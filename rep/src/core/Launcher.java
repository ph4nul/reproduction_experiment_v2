package core;

import simulation.*;

public class Launcher {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int n=20;	//�G�[�W�F���g��;
		int n0=20;	//�����G�[�W�F���g��
		int edge=19;	//�G�[�W�F���g������̃G�b�a��
		Simulation.start(Seed._seeds[2],n,n0,edge);
		long endTime = System.currentTimeMillis();
		System.out.println("time�F" + ((endTime - startTime)/1000) + " s");
	}
}
