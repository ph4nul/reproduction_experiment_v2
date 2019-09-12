package general_metanorms_game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import agent.*;

public class PrintScoreOfGame {
	public static void makeFile(int times,int num) {
		try {
			//出力先を作成する
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\score\\score_"+times+".csv", false);  //※１
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.print(",");
			for(int i=0;i<num;i++) {
				pw.print("Agent_"+i);
				pw.print(",");
			}
			pw.println();
        
			//ファイルに書き出す
			pw.close();
		} catch (IOException ex) {
			//例外時処理
			ex.printStackTrace();
		}
	}
	
	public static void writeLap(int lap,int times) {
		try {
			//出力先を作成する
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\score\\score_"+times+".csv", true);  //※１
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("lap_"+lap);
			
			
			//ファイルに書き出す
			pw.close();
		} catch (IOException ex) {
			//例外時処理
			ex.printStackTrace();
		}
	}
	
	public static void writeScore(int phase,int times,int num,Agent[] agents) {
		try {
			//出力先を作成する
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\score\\score_"+times+".csv", true);  //※１
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.print(phase);
			pw.print(",");
			for(int i=0;i<num;i++) {
				pw.print(agents[i].getScore());
				pw.print(",");
			}
			pw.println();
        
			//ファイルに書き出す
			pw.close();
		} catch (IOException ex) {
			//例外時処理
			ex.printStackTrace();
		}
	}
	
}
