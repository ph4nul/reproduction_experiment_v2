package core;

import simulation.*;

public class Launcher {

	public static void main(String[] args) {
		int n=20;	//�G�[�W�F���g��;
		int n0=20;	//�����G�[�W�F���g��
		int edge=19;	//�G�[�W�F���g������̃G�b�a��
		Simulation.start(Seed._seeds[0],n,n0,edge);
	}
}
