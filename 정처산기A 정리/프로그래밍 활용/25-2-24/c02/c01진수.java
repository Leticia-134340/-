package c02;

public class c01진수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//%d : 10진수 서식문자
		//%o : 8진수 서식문자
		//%x : 16진수 서식문자
		//코드 정리하기 : ctrl + shift + f
		System.out.printf("10진수 : %d\n",0b00001111);
		System.out.printf("10진수 : %d\n",173); // 10진수
		System.out.printf("10진수 : %d\n",0255); // 8진수(0 : 8진수를 의미하는 접두사)
		System.out.printf("10진수 : %d\n",0xAD); // 16진수(0x : 16진수를 의미하는 접두사)
		
		System.out.printf("8진수 : %o\n",173); // 10진수
		System.out.printf("8진수 : %o\n",0255); // 8진수(0 : 8진수를 의미하는 접두사)
		System.out.printf("8진수 : %o\n",0xAD); // 16진수(0x : 16진수를 의미하는 접두사)
		
		System.out.printf("16진수 : %X\n",173); // 10진수
		System.out.printf("16진수 : %X\n",0255); // 8진수(0 : 8진수를 의미하는 접두사)
		System.out.printf("16진수 : %X\n",0xAD); // 16진수(0x : 16진수를 의미하는 접두사)
		
		
	}

}
