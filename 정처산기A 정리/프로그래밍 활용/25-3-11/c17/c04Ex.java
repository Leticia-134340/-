package c17;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class c04Ex {

	public static void main(String[] args) {
		
		//1) 1~45 까지 숫자 중 6개 랜덤으로 받아(Random클래스를 이용) set에 저장
		
		Set<Integer> set = new HashSet();
		Random random = new Random();
		while(set.size()<6) {
			set.add(random.nextInt(45)+1);
			
		}
		for (Integer val : set) 
			System.out.print(val+" ");
		System.out.println("\n------------");
		
		//2) [추가]저장된 set의 오름차순 정렬 시도
		List<Integer> li = set.stream().sorted().collect(Collectors.toList());
//		for(Integer val : li) {
//			System.out.println(val +" ");
//		}

	}

}
