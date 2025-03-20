package c33;

@FunctionalInterface	//함수형인터페이스 선언(Compiler에게 전달)
interface Func1{
	void say(String message); 	//추상메서드
}

public class c01FunctionalInterfaceMain {

	public static void main(String[] args) {
		
		//01
		Func1 func1 = (message)->{System.out.println(message+"_!");};
		func1.say("HELLO WORLD");
		
		Func1 func1_1 = System.out::println;
		func1_1.say("HELLO WORLD");

	}

}
