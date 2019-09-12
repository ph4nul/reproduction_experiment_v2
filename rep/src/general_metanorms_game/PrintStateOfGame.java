package general_metanorms_game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import agent.Agent;

public class PrintStateOfGame {
	public static void makeFile(int times) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", false);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("Game"+times+"start!!");
			pw.println("----------");
        
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
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("lap_"+lap);
			pw.println("----------");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeAgent(int num,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("Agent"+num);
			pw.println("-----");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeCoordination(int num,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(num+" cooperated.");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeBetrayal(int num,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(num+" betrayed!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeFind(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.print("           "+numj+" find "+numi+".");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeNotFind(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("           "+numj+" not find "+numi+"!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeComment(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" comment "+numi+"!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeNotComment(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" not comment "+numi+".");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeMetaComment(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" metacomment "+numi+"!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeNotMetaComment(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" not metacomment "+numi+".");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writePunish1(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" punish(1) "+numi+"!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeNotPunish1(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" not punish(1) "+numi+".");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeFind2(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.print("                                      "+numj+" find "+numi+".");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeNotFind2(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("                                      "+numj+" not find "+numi+"!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writePunish2(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" punish(2) "+numi+"!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeNotPunish2(int numi,int numj,int times,Agent[] agents) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(numj+" not punish(2) "+numi+"!");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeEnd(int times) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println();
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
	public static void writeLine(int times) {
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter("C:\\work\\lab\\game\\yazirusi_game"+times+".txt", true);  //���P
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("---------------");
        
			//�t�@�C���ɏ����o��
			pw.close();
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
	
}
