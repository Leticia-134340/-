package c31;

import java.util.Scanner;

interface Printer{		//람다식은 추상 메서드가 1개만 있어야 적용이 된다
//	void print(String message);		//추상메서드
//	String print(String message);		//추상메서드
	String print();					//추상메서드
}

public class c02LAMDA {

	public static void main(String[] args) {
		
		//01
//		Printer printer = (message)->{System.out.println(message);};
//		printer.print("HELLOWORLD");
		
		//02
//		Printer printer = message->message+"_HELLOWORLD";	//람다식 입력	// 한줄일 경우 약식으로 화살표만 사용 가능
//		String returnValue = printer.print("TEST");
//		System.out.println(returnValue); //TEST_HELLOWORLD가 출력
		
		//03 (키보드로 입력받아 String 반환)
		
		Printer printer = ()->{
			Scanner sc = new Scanner(System.in);
			System.out.print("입력 : ");
			String str = sc.nextLine();
			sc.close();
			return str;
		};
		String returnValue = printer.print();
		System.out.println(returnValue);
		

	}

}
