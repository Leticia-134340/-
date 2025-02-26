package c03;

public class c05TypeChange {

	public static void main(String[] args) {
		
		int num1 = 10, num2 = 4;
		double dnum1 = num1 / num2;	//앞의 num1을 double 형으로 바꾼다
		double dnum2 = num1 / num2;	//(num1 * 1.0)을 하면 저절로 형변환이 된다
		double dnum3 = num1 / num2;
		
		System.out.println("dnum1 : " + dnum1 );
		System.out.println("dnum2 : " + dnum2 );
		System.out.println("dnum3 : " + dnum3 );

	}

}
