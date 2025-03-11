package c17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class c02Ex {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void func1(List<String> list) {
		//ArrayList에 있는 정수값을 입력받는데 전달되는 수중에
		//짝수의 값만 입력받는 코드를 작성하세요.
		int tmp=0;
		while(true) {
			System.out.print("입력(종료:-1) : ");
			try {
				tmp = sc.nextInt();
			}catch(Exception e){
				System.out.println("잘못된 값입니다. 다시 입력하세요 : ");
				System.exit(-1);
			}
			if(tmp == -1) 
				break;
			else if(tmp % 2 == 0)
				list.add(String.valueOf(tmp));
			else 
				System.out.println("짝수만 입력하세요");
		}
		System.out.println("입력을 마쳤습니다.");
	}
	
	public static List<String> func2(List<String> list){
		//ArrayList에 있는 문자열 중에서 길이가 5보다 큰 문자열만 필터링해서 리턴하는 함수를 만드세요
		List<String> returndList = new ArrayList();
		for(String el : list) {
			if (el.length()>5) {
				returndList.add(el);
			}
		}
		return returndList;
	}
		
	public static int func3(List<String> list) {
		//ArrayList에 있는 문자열 중에서 숫자형 데이터만 추출해서 합을 구해보세요
		int sum = 0;
		for(String el : list) {
			sum += Integer.parseInt(el);
		}
		
		return sum; //바꿔주세요 작업시
	}
	
	public static void main(String[] args) {
		List<String> li = new ArrayList();
		func1(li);
		
		List<String> returndList =  func2(li);
		returndList.forEach(System.out::println);
		int sum =  func3(returndList);
		
		System.out.println(sum);
	}

}
