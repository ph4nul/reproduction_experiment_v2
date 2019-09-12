package general_metanorms_game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import agent.*;

public class PrintScoreOfGame {
	public static void makeFile(int times,int num) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\score\\score_"+times+".csv", false);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.print(",");
			for(int i=0;i<num;i++) {
				pw.print("Agent_"+i);
				pw.print(",");
			}
			pw.println();
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeLap(int lap,int times) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\score\\score_"+times+".csv", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("lap_"+lap);
			
			
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeScore(int phase,int times,int num,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\score\\score_"+times+".csv", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.print(phase);
			pw.print(",");
			for(int i=0;i<num;i++) {
				pw.print(agents[i].getScore());
				pw.print(",");
			}
			pw.println();
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
}
