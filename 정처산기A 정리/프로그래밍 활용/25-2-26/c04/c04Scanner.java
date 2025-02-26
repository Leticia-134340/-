package c04;

import java.util.Scanner;

public class c04Scanner {

	public static void main(String[] args) {
		// 이름을 입력하세요? 홍길동
		// 홍길동 님의 나이를 입력하세요? 35
		// 홍길동 님의 주소를 입력하세요? 대구광역시 달서구 000
		// 홍길동 님의 나이는 35세 주소는 대구광역시 ~~ 입니다
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String str1 = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int num1 = sc.nextInt();
		
		sc.nextLine(); //한번 더 입력하는 란을 넣어야한다
		System.out.print("주소를 입력하세요 : ");
		String str2 = sc.nextLine();
		
		System.out.printf("%s님의 나이는 %d세 주소는 %s입니다", str1, num1, str2);
		sc.close();


	}

}
