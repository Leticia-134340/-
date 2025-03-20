package c12;

class c08Super{
	
	void func1() {
		System.out.println("c08.Super.func1() Call!");	
	}
	void func2() {};	//오버라이딩
}
class c08Sub extends c08Super{
	
	void func2() {
		System.out.println("c08.c08Sub.func2() Call!");
	}
}

public class c08UpDownCastingMain {

	public static void main(String[] args) {
		
		c08Super ob1 = new c08Super();	//Nocasting
		ob1.func1();
		
		System.out.println("---------------");
		c08Sub ob2 = new c08Sub();		//Nocasting
		ob2.func1();
		ob2.func2();
		
		System.out.println("---------------");
		c08Super ob3 = new c08Sub();	//Upcasting
		ob3.func1();
		ob3.func2();
		
		//Upcasting
		//확장된(멤버추가) 멤버변수 접근 가능? x -> Downcasting -> 접근
		//확장된(멤버추가) 멤버함수 접근 가능? x -> Downcasting -> 접근
		//재정의된 메서드 접근 가능? o
	}

}
