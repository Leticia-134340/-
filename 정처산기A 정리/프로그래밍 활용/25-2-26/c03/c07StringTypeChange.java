package c03;

public class c07StringTypeChange {

	public static void main(String[] args) {

		//-------------------------
		//문자열 + 문자열
		//-------------------------
//		System.out.println("문자열1" + "문자열2");
//		System.out.println("문자열1" + "문자열2");				//문자열 + 문자열
//		System.out.println("문자열1" + ',' + "문자열2");		//문자열 + 문자 + 문자열
//		System.out.println("문자열1" + 2);					//문자열 + 숫자 -> 숫자를 문자열로 해석 단순연결
//		System.out.println("문자열" + ',' + '!');
//		System.out.println(',' + '!' + "문자열");
//		System.out.println("문자열1" + "문자열2");
		
		//-------------------------
		//문자열 -> 숫자형 변환
		//-------------------------
		//문자열 -> 숫자형으로 변환(정수)
		//int n1 = "10";
		
//		System.out.println("10"+"20");		//문자열 연결
//		int n1 = Integer.parseInt("10");	//웹개발코드 시 폼으로부터 전달받은 값은 다 문자열 //Integer.parseInt은 문자열로 표시된 숫자를 int형으로 바꿔준다
//		int n2 = Integer.parseInt("20");
//		System.out.println(n1+n2);
//		
//		//문자열 -> 숫자형을 변한(실수)
//		double n3 = Double.parseDouble("10.5"); // Double.parseDouble: Integer.parseInt와 같은 기능
//		double n4 = Double.parseDouble("20.4");
//		System.out.println(n3+n4);
//		
//		short n5 = Short.parseShort("5");
//		short n6 = Short.parseShort("6");
//		
//		System.out.println(n5+n6);
		
		

		
		String str1 = 2 + 3 + "";
		String str2 = 2 + "" + 3;
		String str3 = "" + 2 + 3;
		System.out.println(str1); 	//5
		System.out.println(str2);	//2 3
		System.out.println(str3);
	}

}
