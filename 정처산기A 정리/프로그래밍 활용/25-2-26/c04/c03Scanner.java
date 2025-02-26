package c04;

import java.util.Scanner;

public class c03Scanner {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("입력된 정수 값 : " +num1);
		
		System.out.print("문자열 입력(띄어쓰기포함) : ");
		String str2 = sc.nextLine();
		System.out.println("문자열 : " + str2);

//		
//		System.out.print("실수 입력 : ");
//		double num2 = sc.nextDouble();
//		System.out.println("입력된 실수 값 : " +num2);
		
//		System.out.print("문자열 입력");
//		String str1 = sc.next();		//문자열입력받기가능함수, 띄어쓰기는 포함하지 않는다
//		System.out.println("입력된 문자열 : "+str1);
		

	}

}
