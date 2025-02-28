package c07;

import java.util.Scanner;

public class c02While {

	public static void main(String[] args) {
		
		//2단 - 9단 출력
		
//		int dan = 2;
//		while(dan<10) {	//구구단 앞 숫자
//			
//			int i=1;
//			while(i<10) {	//구구단 뒷 숫자 10이 되면 바깥으로 나가 dan을 올리고 다시 실행
//				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		//2단 -9단 출력 (2x9, 2x8,...,9x9,...,9x1)
		
//		int dan = 2;
//		while(dan<10) {	//구구단 앞 숫자
//			
//			int i=9;
//			while(i>0) {	//구구단 뒷 숫자 10이 되면 바깥으로 나가 dan을 올리고 다시 실행
//				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		
		//9단 - 2단(9x9,...,2x9,...,2x1)
		
//		int dan = 9;
//		while(dan>1) {	//구구단 앞 숫자
//			
//			int i=9;
//			while(i>0) {	//구구단 뒷 숫자 10이 되면 바깥으로 나가 dan을 올리고 다시 실행
//				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			
//			dan--;
//		}

		
		//2단 - N단(N<9)
		
//		Scanner sc = new Scanner(System.in);
//		
//		int dan = 2;
//		System.out.print("n 입력 : ");
//		int n = sc.nextInt();
//		
//		while(2>n || n>9)	//2와 9 사이에 값을 입력하지 않으면 작동 x
//		{
//			System.out.println("구구단의 범위는 2 - 9 사이값을 입력하셔야합니다");
//			System.out.print("n 입력 : ");
//			n = sc.nextInt();
//		}
//		while(dan<n+1) {	//구구단 앞 숫자
//			
//			int i=1;
//			while(i<10) {	//구구단 뒷 숫자 10이 되면 바깥으로 나가 dan을 올리고 다시 실행
//				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		//N단 - M단(N<M , N<9 , M<9)
		
//		Scanner sc = new Scanner(System.in);
//				
//		System.out.print("n 입력 : ");
//		int n = sc.nextInt();
//		
//		if(n>9) {		//n에서 9 초과값이 입력되면 오류 뜬다
//			System.out.println("구구단의 범위는 9 이하값을 입력하셔야합니다");
//			System.out.print("n 입력 : ");
//			n = sc.nextInt();
//		}
//		
//		System.out.print("m 입력 : ");			//순차적으로 읽어내려오기 때문에 n 입력 받고 오류 뜨게 하고 
//												//m 입력하고 오류뜨게 만들어야한다 한꺼번에 처리하게 하면 하나는 처리가 안된다
//		int m = sc.nextInt();
//		
//		
//		if(m>9) {		//m에서 9초과값을 입력하면 오류뜬다
//			System.out.println("구구단의 범위는 9 이하값을 입력하셔야합니다");
//			System.out.print("m 입력 : ");
//			m = sc.nextInt();
//		}
//		
//		while(n>m) {
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//
//		while(n<m) {	//구구단 앞 숫자
//			
//			int i=1;
//			while(i<10) {	//구구단 뒷 숫자 10이 되면 바깥으로 나가 dan을 올리고 다시 실행
//				System.out.printf("%d x %d = %d\n",n,i,n*i);
//				i++;
//			}
//			System.out.println();
//			
//			n++;
//		}
		
		
//		System.out.println(); 으로 하면 안된다 
//		별은 1개씩 찍어야한다
		//별찍기(기본높이:4)
		

		//*****
		//*****
		//*****
		//*****
		
//		Scanner sc = new Scanner(System.in);
//		
//		int i = 0;
//		while(i<4)
//		{
//			int j = 0;
//			while (j<5) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i++;
//		}
//		
		//높이 h 입력 받기
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		
//		int i = 0;
//		while(i<h+1)
//		{
//			int j = 0;
//			while (j<5) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i++;
//		}
		//*
		//**
		//***
		//****

		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		
//		int i = 0;
//		while(i<h)
//		{
//			int j = 0;
//			while (j<i+1) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i++;
//		}
		
		//****
		//***
		//**
		//*
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		
//		int i=0;
//		while(i<4)
//		{
//			int j=0;
//			while (j<4-i) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}

		
		//   *
		//  ***
		// *****
		//*******
	
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
		
//		int i = 0;
//		while(i<4)
//		{
//			int n=0;
//			while(n<4-i)
//			{
//				System.out.print(" ");
//				n++;
//			}
//			int j = 0;
//			while (j<i*2+1) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i++;
//		}
		
		//높이 값 받기
		//   *
		//  ***
		// *****
		//*******
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
		
//		int i = 0;
//		while(i<h)
//		{
//			int n=0;
//			while(n<(h-1)-i)
//			{
//				System.out.print(" ");
//				n++;
//			}
//			int j = -1;
//			while (j<2*i) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i++;
//		}
		
		//*******
		// *****
		//  ***
		//   *

//		int i = 0;
//		while(i<4)
//		{
//			int n=0;
//			while(n<i+1)
//			{
//				System.out.print(" ");
//				n++;
//			}
//			int j = 0;
//			while (j<8-(2*i+1)) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i++;
//		}
		
		//높이값 받기
		//*******
		// *****
		//  ***
		//   *
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int i = 0;
//		while(i<h)
//		{
//			int n=0;
//			while(n<i)
//			{
//				System.out.print(" ");
//				n++;
//			}
//			int j = -1;
//			while (j<((h-1)*2)-2*i) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i++;
//		}
		
		
		
		//마름모는 중간을 기점으로 어디서 잘라내서 분기문을 만들지 생각해야한다 보통은 중앙이다
		
		
		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *

//		int i1 = 0;
//		while(i1<4)
//		{
//			int n=0;
//			while(n<4-i1)
//			{
//				System.out.print(" ");
//				n++;
//			}
//			int j = 0;
//			while (j<i1*2+1) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i1++;
//		}
//		int i2 = 5;
//		while(i2<8)
//		{
//			int n=-1;
//			while(n<i2-4)
//			{
//				System.out.print(" ");
//				n++; 
//			}
//			int j = 0;
//			while (j<7-2*n) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i2++;
//		}
//		
//		-----------------------------------------------------------
//		높이 값 받기
		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *
		
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();	//기본적으로 홀수값만 입력 받도록 해야한다
		
		int i = 0;
		while(i<h)
		{
			if(i<=(h/2)) {
				
			int n=0;
			while(n<(h/2)-i)
			{
				System.out.print(" ");
				n++;
			}
			int j = 0;
			while (j<=2*i) {
				System.out.printf("*");
				j++;
			}
		}else {
	
			int n=0;
			while(n<=i-(h/2+1))
			{
				System.out.print(" ");
				n++; 
			}
			int j = 0;
			while (j<=((h-1)*2)-2*i) {
				System.out.printf("*");
				j++;
			}
		}
			System.out.println();
			
			i++;
		}
		sc.close();
//		
		
		
		
		//*******
		// *****
		//  ***
		//   *		
		//   *
		//  ***
		// *****		
		//*******

//		int i1 = 0;
//		while(i1<4)
//		{
//			int n=0;
//			while(n<i1+1)
//			{
//				System.out.print(" ");
//				n++;
//			}
//			int j = 0;
//			while (j<8-(2*i1+1)) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i1++;
//		}
//		int i2 = 5;
//		while(i2<9)
//		{
//			int n=-1;
//			while(n<-i2+8)
//			{
//				System.out.print(" ");
//				n++;
//			}
//			int j = 0;
//			while (j<7-2*n) {
//				System.out.printf("*");
//				j++;
//			}
//			System.out.println();
//			
//			i2++;
//		
//		}
		
	}

}
