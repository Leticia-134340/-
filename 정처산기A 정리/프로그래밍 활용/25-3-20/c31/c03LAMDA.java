package c31;

//
interface Calculato{
	int calculate(int num1, int num2);
}

public class c03LAMDA {

	public static void main(String[] args) {

		//덧셈 - Calculator add
		Calculato add = (num1, num2)->num1+num2;
		
		//뺄셈 - Calculator sub
		Calculato sub = (num1, num2)-> num1>num2? num1-num2:num2-num1;
		
		//곱셈 - Calculator mul
		Calculato mul = (num1, num2)->num1*num2;
		
		//나눗셈 - Calculator div
		Calculato dov = (num1, num2)->num1/num2;
		
		//결과
		System.out.println(add.calculate(10,20));//덧셈
		System.out.println(sub.calculate(30,10));//뺄셈
		System.out.println(mul.calculate(10,20));//곱셈
		System.out.println(dov.calculate(100,5));//나눗셈

	}

}
