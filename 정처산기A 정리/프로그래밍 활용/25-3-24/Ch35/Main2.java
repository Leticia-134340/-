package Ch35;

import java.util.Scanner;

import Ch35.building.Barrack;

public class Main2 {
	//배럭 건물
	static Barrack barrack=null;
	
	public static void main(String[] args) {
		//건물생성
		new Thread() {
			@Override
			public void run() {
				barrack=new Barrack();
			}
		}.start();
		
		Scanner sc = new Scanner(System.in);
		int num = 
		
		while(true) {
			System.out.println("1 마린 생성");
			System.out.println("2 메딕 생성");
			System.out.println("3 종료");
			System.out.println("입력 : ");
			num = sc.nextInt();
			switch(num) {
			
			}
		}
	}
}
