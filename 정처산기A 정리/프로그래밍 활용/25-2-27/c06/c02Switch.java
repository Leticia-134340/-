package c06;

import java.util.Scanner;

public class c02Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ranking = sc.nextInt();
		char medalColor;
		switch (ranking) {
		case 1:
			medalColor = 'G';
			System.out.println("메달색상 : G");
			break;
		case 2:
			medalColor = 'S';
			System.out.println("메달색상 : S");
			break;
		case 3:
			medalColor = 'B';
			System.out.println("메달색상 : B");
			break;
		default:
			medalColor = 'C';
			System.out.println("메달색상 : C");	
		}
		System.out.println(ranking + "등 메달의 색은 "+ medalColor + "입니다.");
	
	}		//위에서부터 해당되는 조건을 찾아 출력함
			//break문을 쓰지 않으면 밑의 조건들을 같이 출력하기 때문에 특별한 경우가 아니면 해야한다/

}
