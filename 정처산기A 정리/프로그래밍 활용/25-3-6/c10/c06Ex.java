package c10;

import java.util.Arrays;
import java.util.Scanner;

public class c06Ex {
	//5개의 정수값을 입력받아 int형 배열에 저장하고
	//최대, 최소, 전체합을 출력
	
	//5명의 학생에 국영수점수를 입력받아 2차원 배열 저장
	//각 학생의 국영수 점수의 합/평균을 구하고
	//각 과목당 합/평균을 구해보세요

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
//		int max = arr1[0];
//		int min = arr1[0];
//		
//		for(int el : arr1) {
//		if(max<el) 
//			max=el;
//		if(min>el)
//			min=el;
//		}
//		System.out.printf("최대값은 "+ max + "이다\n");
//		System.out.printf("최소값은 "+ min + "이다");
		
		Scanner sc = new Scanner(System.in);
		
//		int arr[][] = {
//				{sc.nextInt(), sc.nextInt(),sc.nextInt()},
//				{sc.nextInt(), sc.nextInt(),sc.nextInt()},
//				{sc.nextInt(), sc.nextInt(),sc.nextInt()},
//				{sc.nextInt(), sc.nextInt(),sc.nextInt()},
//				{sc.nextInt(), sc.nextInt(),sc.nextInt()},
//
//				
//
//		};
//		//합 평균
//		arr[0] = 
		
		int score[][] = new int [5][3];
		
		for(int i=0;i<score.length;i++) {
			System.out.printf("%d 번째 학생 국영수 입력 : ",i+1);
			score[i][0] = sc.nextInt(); // 국
			score[i][1] = sc.nextInt(); // 영
			score[i][2] = sc.nextInt(); // 수
		}
		
		//학생별 점수 총점과 평균
		for(int i=0;i<score.length;i++) {
			int sum = score[i][0] + score[i][1] + score[i][2];
			double avg = (double)sum/3;
			System.out.printf("%d 번째 학생 총점 : %d 평균 : %f\n",i+1,sum,avg);
		}
		//과목별 점수 총점
		int subject_sum[] = new int[3];
		for(int i=0;i<score.length;i++) {
			
			int sum=0;
			for(int j=0;j<score.length;j++) {
				
				subject_sum[i] += score[j][i];
			}
		}
		System.out.printf("국어 총점 : %d 국어 평균 : %f\n",subject_sum[0],(double)subject_sum[0]/score.length);
		System.out.printf("영어 총점 : %d 영어 평균 : %f\n",subject_sum[0],(double)subject_sum[1]/score.length);
		System.out.printf("수학 총점 : %d 수학 평균 : %f\n",subject_sum[0],(double)subject_sum[2]/score.length);

	}
}
