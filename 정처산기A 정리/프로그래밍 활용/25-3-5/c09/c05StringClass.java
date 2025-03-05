package c09;

public class c05StringClass {

	public static void main(String[] args) {
//		String str1 = "Java Powerful";
//		String str2 = new String("Java Programming");
//		String str3 = str1+str2;
//		String str4 = str1.concat(str2);
//		
//		System.out.printf("%X\n",System.identityHashCode(str1));
//		System.out.printf("%X\n",System.identityHashCode(str2));
//		System.out.printf("%X\n",System.identityHashCode(str3));
//		System.out.printf("%X\n",System.identityHashCode(str4));
//		
//		int i = 0;
//		String str = "";
//		while (i<10) {
//			str +=i;
//			System.out.print("str : " +str + " ");
//			System.out.printf("위치 : %n\n", System.identityHashCode(str));
//			i++;
//		}
		
		//문자열 덧붙이기(메모리 누수 방지 클래스 : StringBuffer, StringBuilder
		
		int i = 0;
//		String str = "";
		StringBuilder str = new StringBuilder("");
		while (i<10) {
//			str +=i;
			str.append(i);
			System.out.print("str : " + str + " ");
			System.out.printf("위치 : %x\n", System.identityHashCode(str));
			i++;
		}
		
	
	}

}
