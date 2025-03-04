package c07;

//import java.util.Scanner;

public class c01While {

	public static void main(String[] args) {
		
		//"Hello world" 열번 반복
		//탈출용 변수 : i = 0
		//탈출용 조건식 : i<10
		//탈출용 연산식 : i++
		
//		while(조건식) {
//			조건식이 true 인동안 실행되는 종속문장
//		}
		//01 기본 - HELLO WORLD 10회 반복
//		int i=0;
//		while(i<10) {
//			System.out.println("HELLO WORLD");
//			i++;
//		}

		//01 기본 - HELLO WORLD n회 반복
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i=0;
//		while(i<n) {
//			System.out.println("HELLO WORLD");
//			i++;
//		}
		
		//03 기본 - 1부터 10까지의 합
		
//		int i = 1;		//탈출용 변수
//		int sum = 0;
//		while(i<=10)	//탈출용 조건식
//		{
//			System.out.println("i : " + i);
//			sum = sum + i;
//			i++;			//탈출용 연산식
//		}
//		System.out.println("SUM : "+sum);
		
		//04 기본 - 1부터 N까지 합
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i = 1;
//		int sum = 0;
//		while(i<=n)
//		{
//			System.out.println("i : " + i);
//			sum = sum+ i;
//			i++;
//		}
//		System.out.println("SUM : " +sum);
		//05 기본 - N부터 M까지 합(N<M) - N>=M 인 경우 N과 M을 Swap하고 진행합니다		
		//등호 쓴다고 값이 같아지는게 아니라 값이 서로 바뀌는 개념이다
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int sum = n;
//			if(n<m) {
//				while(n<m)
//				{
//					System.out.println("n : "+n);
//					sum = sum +n;
//					n++;
//				} 
//			}
//			else { //잘못 입력한 경우
//				while(m<=n) 
//				{
//				System.out.println("m : "+m);
//				sum = sum +m;
//				m++;
//				}
//			}
//			System.out.println("SUM : " +sum);
		
//		--------------------------------------------
//		Scanner sc = new Scanner(System.in);	//공간 하나 더 생성해서 자리를 옮기는 방식
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int sum = n;
//		if(n>=m) {
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//		while(n<m)
//		{
//			System.out.println("n : "+n);
//			sum = sum +n;
//			n++;
//		} 
//		System.out.println("sum : "+sum);
//			
//		-------------------------------------------------
		//06 N - M 까지 수중(N<M) 짝수의 합, 홀수의 합을 각 구해서 출력하세요
//		-------------------------------------------------
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt(); //최소 직접입력
//		int m = sc.nextInt(); //최대 직접입력
//		int sum = n;
//			if(n>=m) {			//n이 m보다 클 경우 서로 값을 바꾸어서 시작
//				int tmp = n;
//				n=m;
//				m=tmp;
//			}
//			int i=n;
//			int odd_sum = 0;	//홀수	홀수 덧셈 값 설정 0에서 시작
//			int even_sum = 0;	//짝수	짝수 덧셈 값 설정 0에서 시작
//			while(i<=m)
//			{
//				System.out.println("i : "+i);
//				if(i%2==0) {
//					even_sum+=i;
//				}				//짝수일 경우 짝수 덧셈 값에 연산, i = n이기 때문에 최대값 이외에 굳이 위에 식에서 범위를 주지 않아도 알아서 계산이 된다
//				else
//					odd_sum+=i;
//				n++;			//홀수일 경우 홀수 덧셈 값에 연산, i = n이기 때문에 최대값 이외에 굳이 위에 식에서 범위를 주지 않아도 알아서 계산이 된다
//			} 
//			System.out.println(sum);
//			}
			
	//07 1 - N까지 수중에 4의 배수를 출력하고 4의 배수가 아닌 나머지의 합을 구하시오
		
//	Scanner sc = new Scanner(System.in);
//	int n = sc.nextInt();
//	
//	int i=1;
//	while(i<=n) {
//		if(i%4==0) {
//			System.out.println("i : "+i);		//4의 배수만 출력
//		}
//		else
//			sum+=i;								//4의 배수가 아닌 숫자는 지나감
//		i++;	
	//08 구구단 N단을 출력합니다(2<=N<=9)
//		Scanner sc = new Scanner(System.in);
//		System.out.print("n 입력 : ");
//		int n = sc.nextInt();
//		
//		while(2>n || n>9)	//2와 9 사이에 값을 입력하지 않으면 작동 x
//		{
//			System.out.println("구구단의 범위는 2 - 9 사이값을 입력하셔야합니다");
//			System.out.print("n 입력 : ");
//			n = sc.nextInt();
//		}
//		
//		int i=1;
//		while(i<10) {
//			System.out.printf("%d x %d = %d\n", n , i, n*i);	//계산 식을 준 후 각각의 요소들의 관계 정리
//			i++;
//		}
	
	}

}
