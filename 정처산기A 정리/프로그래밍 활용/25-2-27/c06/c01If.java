package c06;

import java.util.Scanner;

public class c01If {

	public static void main(String[] args) {
		
		//--------------------------
		//단순 If
		//--------------------------
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : " );
//		int age = sc.nextInt();
//		if(age>=8)
//			System.out.println("학교에 다닙니다.");
//		System.out.println("첫번째 IF코드 블럭 종료..");
//		if(age<8)
//			System.out.println("학교에 다니지 않습니다.");
//		
//		System.out.println("두번째 IF코드 블럭 종료");
//		System.out.println("프로그램을 종요합니다");
//		
//		
//		sc.close();

//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : " );
//		int age = sc.nextInt();
//		if(age>=8)
//			System.out.println("학교에 다닙니다.");
//		else
//			System.out.println("학교에 다니지 않습니다.");
//		
//		System.out.println("프로그램을 종요합니다");
//		
//		
//		sc.close();
		
		//문제
		//정수 한 개 값을 입력받아 3의 배수이면 해당 수를 출력하세요
		//3의 배수이면서 5의 배수라면 출력 -
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("숫자 : " );
//		int num = sc.nextInt();
//		if(num%3==0) 
//		{
//			System.out.println("3의 배수입니다");
//			if(num%5==0) 
//			{
//				System.out.println("3과 5의 배수입니다");
//			}
//			}
//		else 
//		{
//			System.out.println("조건에 만족하지 않습니다.");
//			}
		//sc.close();
		
		//문제 2
		//두개의 정수 큰수 출력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("첫번째 숫자 : ");
//		int num1 = sc.nextInt();
//		
//		System.out.println("두번째 숫자 : ");
//		int num2 = sc.nextInt();
//		
//		if(num1>num2) {
//			System.out.printf(num1+"이 더 큽니다");
//		}
//		if(num1<num2) {
//			System.out.printf(num2+"이 더 큽니다");
//		}
		
		//sc.close();
		//문제3
		//세개의 정수 중 큰수 출력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("첫번째 숫자 : ");
//		int num1 = sc.nextInt();
//		
//		System.out.println("두번째 숫자 : ");
//		int num2 = sc.nextInt();
//		
//		System.out.println("세번째 숫자 : ");
//		int num3 = sc.nextInt();
//		
//		if((num1>num2)&&(num1>num3)) {
//			System.out.printf(num1+"이 가장 큽니다");
//		}
//		if((num1<num2)&&(num3<num2)) {
//			System.out.printf(num2+"이 가장 큽니다");
//		}
//		if((num1<num3)&&(num2<num3)) {
//			System.out.printf(num3+"이 가장 큽니다");
//		}
		//sc.close();
		
		//max = num1을 해서 나머지 다른 수를 각각 max<n2, max<n3을 하는 방법도 있다
		//else if
//		
		//문제4
		//정수 3개 입력 시 합과 평균 촐력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("첫번째 숫자 : ");
//		int num1 = sc.nextInt();
//		
//		System.out.println("두번째 숫자 : ");
//		int num2 = sc.nextInt();
//		
//		System.out.println("세번째 숫자 : ");
//		int num3 = sc.nextInt();
//		
//		
//		int sum = num1 + num2 + num3;
//		System.out.println(sum);
//		int avg = sum/3;
//		System.out.println(avg);
		
		
		//문제5
		//입력한 수가 짝수이고, 3의 배수라면 출력
		//입력한 수가 홀수이고, 5의 배수라면 출력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("숫자 입력 : ");
//		int num = sc.nextInt();
//		
//		if((num%2==0)&&(num%3==0)) {
//			System.out.println(num+"은 짝수이며 3의 배수입니다");
//		}
//		if((num%2==1)&&(num%5==0)) {
//			System.out.println(num+"은 홀수이며 5의 배수입니다");
//		}
//		
//		sc.close();
		
		
//		------------------------
//		If - else if - else
//		------------------------
//		과목1,2,3,4 중 하나라도 40점 미만이면 불합격
//		과목 평균이 100점만점 기준으로 60점 미만이면 불합격
//		아니면 합격
		
//		Scanner sc = new Scanner(System.in);
//		int 과목1 = sc.nextInt();
//		int 과목2 = sc.nextInt();
//		int 과목3 = sc.nextInt();
//		int 과목4 = sc.nextInt();
//		double 평균 = (double)(과목1+과목2+과목3+과목4)/4;
//		
//		if(과목1<40) {
//			System.out.println("불합격");
//		}
//		else if(과목2<40)			//과목1>=40 &&과목2<40
//		{
//			System.out.println("불합격");
//		}
//		else if(과목3<40) 		//과목1>=40 &&과목2>40&&과목3<40
//		{
//			System.out.println("불합격");
//		}
//		else if(과목4<40) 
//		{
//			System.out.println("불합격");
//		}
//		else if(평균<60)
//		{
//			System.out.println("불합격");
//		}
//		else
//		{
//			System.out.println("합격");
//		}
		
		//문제
		//시험점수
		//90점부터 A
		//80점대는 B
		//70점대는 C
		//60점대는 D
		//그 이하는 F
//		Scanner sc = new Scanner(System.in);
//		int score = sc.nextInt();
//		
//		if(score>=90) {
//			System.out.println("A");
//		}
//		else if((score>=80&&score<90))			//과목1>=40 &&과목2<40
//		{
//			System.out.println("B");
//		}
//		else if((score>=70&&score<80)) 		//과목1>=40 &&과목2>40&&과목3<40
//		{
//			System.out.println("C");
//		}
//		else if((score>=60&&score<70)) 
//		{
//			System.out.println("D");
//		}
//		else
//		{
//			System.out.println("F");
//		}
		
//		문제
		//나이별로 요금 부과
		//8세 미만은 1000원
		//8세 이상 14세 미만은 2000원
		//14세 이상 20세 미만은 2500원
		//20세 이상은 3000원
//		Scanner sc = new Scanner(System.in);
//		int age = sc.nextInt();
//		
//		if(age<8) {
//			System.out.println("1000원 입니다");
//		}
//		else if((age>=8&&age<14))			//과목1>=40 &&과목2<40
//		{
//			System.out.println("2000원 입니다");
//		}
//		else if((age>=14&&age<20)) 		//과목1>=40 &&과목2>40&&과목3<40
//		{
//			System.out.println("2500원 입니다");
//		}
//		else
//		{
//			System.out.println("3000원 입니다");
//		}
		//위에서 조건을 충족못할 경우 밑으로 내려옴

		
		
	}

}
