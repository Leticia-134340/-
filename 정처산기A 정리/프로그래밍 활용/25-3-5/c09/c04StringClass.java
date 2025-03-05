package c09;

public class c04StringClass {

	public static void main(String[] args) {
		
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(str3);
//		System.out.println(str4);
		//str1,2,3,4의 차이는 이 로그를 통해 알 수 있다
		System.out.printf("%X\n",System.identityHashCode(str1));
		System.out.printf("%X\n",System.identityHashCode(str2));
		System.out.printf("%X\n",System.identityHashCode(str3));
		System.out.printf("%X\n",System.identityHashCode(str4));
	
		System.out.println("---------------------------");
		System.out.println("str1==str2 ?"+(str1==str2));
		System.out.println("str3==str4 ?"+(str3==str4));
		System.out.println("str1==str3 ?"+(str1==str3));
		System.out.println("str2==str4 ?"+(str2==str4));
		System.out.println("---------------------------");
		//문자열 일치 확인
		System.out.println("str1==str2 ?"+(str1.equals(str2)));
		System.out.println("str3==str4 ?"+(str3.equals(str4)));
		System.out.println("str1==str3 ?"+(str1.equals(str3)));
		System.out.println("str2==str4 ?"+(str2.equals(str4)));
		System.out.println("---------------------------");
	}

}
