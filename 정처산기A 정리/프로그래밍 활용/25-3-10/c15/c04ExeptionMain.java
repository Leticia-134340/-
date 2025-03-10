package c15;

public class c04ExeptionMain {

	public static void main(String[] args) {
		
		String str = null;
		try {
			str.toString();						//null 예외발생
		
			int arr[] = {10,20,30};
			arr[5] = 100;						//Bound Exception 발생
			Integer.parseInt("a1234");			//Parse Exception 발생
			
			Animal animal = new Dog();
			Cat yummi = (Cat)animal;			//Cast Exception
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			//자원정리 작업
			System.out.println("Finally Test..");
		}
		
		System.out.println("HELLOWORLD");

	}
	
//	String str = null;
//	try {
//	str.toString();						//null 예외발생
//	
//	int arr[] = {10,20,30};
//	arr[5] = 100;						//Bound Exception 발생
//	Integer.parseInt("a1234");			//Parse Exception 발생
//	}catch(NullPointerException e) {
//		System.out.println(e.getMessage());
//	}catch(ArrayIndexOutOfBoundsException e2) {
//		System.out.println(e2.getMessage());
//	}
//		Animal aimal = new Dog();
//		Cat yummi = (Cat)animal;			//Cast Exception
//		System.out.println("예외처리 : "+ e);
//	
//	System.out.println("HELLOWORLD");
//
//}

}
