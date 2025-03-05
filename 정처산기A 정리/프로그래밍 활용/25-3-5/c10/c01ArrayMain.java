package c10;

import java.util.Arrays;
import java.util.Scanner;

import c01.c01SystemOut;

public class c01ArrayMain {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int[] arr1 = new int[5];
//		System.out.println("배열길이 : " + arr1.length);
//		System.out.println("5개의 값을 입력하세요");
//		arr1[0] = sc.nextInt();
//		arr1[1] = sc.nextInt();
//		arr1[2] = sc.nextInt();
//		arr1[3] = sc.nextInt();
//		arr1[4] = sc.nextInt();
//
//		for(int i=0;i<=arr1.length;i++) {
//			System.out.println(i+"."+arr1[i]);
//		}
//		System.out.println("-------------------");
//		for(int el : arr1) {
//			System.out.println(el);
//		}
//		System.out.println("-------------------");
////		Arrays.stream(arr1).forEach(el -> System.out::println(el));
//		Arrays.stream(arr1).forEach(System.out::println);
//		
		//입력된 값 중에 최소와 최대값 구하기
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[5];
		System.out.println("배열길이 : " + arr1.length);
		System.out.println("5개의 값을 입력하세요");
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();
		
		int max = arr1[0];
		int min = arr1[0];
		
		for(int el : arr1) {
		if(max>el) 
			max=el;
		if(min<el)
			min=el;
		}
		System.out.printf("최대값은"+ max + "이다");
		System.out.printf("최소값은"+ min + "이다");
		
		System.out.println("MAX : " + Arrays.stream(arr1).max().getAsInt());
		System.out.println("MIN : " + Arrays.stream(arr1).max().getAsInt());
		

	}
}
