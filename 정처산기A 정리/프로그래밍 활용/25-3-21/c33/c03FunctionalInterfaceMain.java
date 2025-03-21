package c33;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import c01.c01SystemOut;

//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스 입니다.

//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스 입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스 입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스 입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.

public class c03FunctionalInterfaceMain {
	
	//01
	public static Function<Integer, Integer> func1=x->x*x;	//<입력값,반환값>
	//02
	public static Function<Integer, Integer> func2=x->x+x;
	//03
	//값을 여러개 받고 싶을 때 - <List<>,>
	public static Function<List<Integer>, Integer> func3=(x)->x.stream().reduce(0,(sum,el)->sum+el);
	//04 숫자만이 아닌 모든 값을 받고 싶을 때 최상위값(Object)를 쓴다
	public static Function<List<Object>, Integer> func4=(li)->{
		//리스트로 받은 값 중에 Integer형만 필터링(instanceof)
		//누적합(reduce)
		
			return li			.stream()
								.filter(item -> item instanceof Integer)
								.mapToInt(item->(Integer)item)
								.reduce(0,(a,b)->a+b);
		
		
		
	};
	//05
	public static Function<List<Object>, List<Integer>> func5=(li)->{	//<리스트 입력 유형 모두 받기,
																		//Integer 리스트로 반환>
		//Integer 필터링
		//재구성(map)
		//리스트로 변환(collect)
		
		return li		.stream()
						.filter(item -> item instanceof Integer)
						.map(item->(Integer)item)
						.collect(Collectors.toList());
	};
		
//		return list.stream().reduce(0,(sum,el)->sum+el);
		
	//06 위의 func1와 func2를 연결	//func1의 곱셈을 수행하고 이어서 func2의 덧셈을 수행한다
	public static Function<Integer,Integer> func6=func1.andThen(func2);
	
	//07
	public static Function<Integer,Integer> func7=func2.andThen(func1);
	
	//08
//	public static Function<List<Object>,Integer> func8=func5.andThen(func4);
	//위의 식은 함수 5에서 int 반환이 이루어졌는데 4에서 Object를 받고 있기 때문에 오류가 뜬다
	public static Function<List<Integer>,Integer> subfunc = x->{return x.stream().reduce(0, (sum,x1)->sum+x1);};
	public static Function<List<Object>,Integer> func8=func5.andThen(subfunc);
	
	//09
	public static Function<Integer,Function<Integer, Integer>> func9=(x)->{
									System.out.println("첫 번째 함수 : "+x);
									return (x1)->{return x1+x1;};}; 
									
	//10
	public static Function<Integer, Function<Integer, Integer>> func10 = x->y->x+y;

	//11
	public static Function<Integer, Function<Function<Integer,Integer>, Integer>> func11 = x->y->z->x*y*z;

	public static void main(String[] args) {
		
		//01
		System.out.println(func1.apply(7));
		//02
		System.out.println(func2.apply(7));
		//03
		System.out.println(func3.apply(Arrays.asList(10,20,30,40)));
		//04
		System.out.println(func4.apply(Arrays.asList("홍길동",55,38,24,10.5,true,46)));
		//05
		System.out.println(func5.apply(Arrays.asList("홍길동",55,38,24,10.5,true,46)));
		//06
		System.out.println(func6.apply(4));
		//07
		System.out.println(func7.apply(4));
		//08
		System.out.println(func8.apply(Arrays.asList("적길동",36,44,12,7,13,false,17)));
		//09
		System.out.println(func9.apply(7).apply(9));
		//10
		System.out.println(func10.apply(7).apply(9));
		//11
		System.out.println(func11.apply(7).apply(9).apply(11));
		
	}

}
