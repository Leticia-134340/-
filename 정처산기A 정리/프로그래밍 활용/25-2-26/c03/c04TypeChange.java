package c03;

public class c04TypeChange {

	public static void main(String[] args) {
		
		//정수 연산식(int보다 작은 변수자료형(short, char, byte))
		//int 로 자동 형변환
//		byte x = 10;
//		byte y = 20;
//		byte result1 = x + y;	//기본 연산식이 들어갈 경우 ram에서 cpu로 이동할 때 자동 형변환이 일어나 int가 된다. 왼쪽은 바이트라서 문제가 생긴다
//								//방법 : x + y를 (x + y)로 바꿔서 (byte)를 붙인다
//		
//		int result2 = x + y;
//		System.out.println(result1);
		
		//정수 연산식(int 보다 큰 변수 자료형(long))
		//큰 타입으로 자동 형변환
		
//		byte var1 = 10;
//		int var2 = 100;
//		long var3 = 1000L;
//		int result = var1 + var2 + var3;	//(var1 + var2 + var3)로 바꿔서 (long)로 바꾸거나 처음부터 int로 바꾼다
//		
//		long result2 = var1 + var2 + var3;
		//System.out.println(result2);
		
		//실수연산식
		//큰 타입으로 자동 형변환
//		int intvar = 10;
//		float flvar = 3.3F;
//		double dbvar = 5.5;
//		int result3 = intvar + flvar + dbvar;	//invar, flvar 가 각각 double형으로 형변환 된 값이 더해져서 result 3에 저장
//														//(int)(intvar + flvar + dbvar)로 변경
//		double result4 = intvar + flvar + dbvar;
//		System.out.println(result3);

	}

}
