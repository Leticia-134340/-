package c10;

import java.util.Arrays;

public class c02ArrayMain {

	public static void main(String[] args) {


		//얕은 복사(주소복사)
		int arr1[] = {10,20,30};
		int arr2[];
		arr2 = arr1;
		arr1[0] = 100; //배열의 0번째 칸에 100을 삽입한다, arr2에도 적용(복사됨)
		
		Arrays.stream(arr1).forEach(System.out::println);
		System.out.println("--------------------------");
		Arrays.stream(arr2).forEach(System.out::println);
		
		//깊은 복사(값복사)
		int arr3[] = new int[3];
		for(int i=0;i<arr1.length;i++)
			arr3[i] = arr1[i];
		
		//Arrays API
		int arr4[] = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("arr1 : " + arr1);
		System.out.println("arr1 : " + arr2);
		System.out.println("arr1 : " + arr3);
		System.out.println("arr1 : " + arr4);

	}

}
