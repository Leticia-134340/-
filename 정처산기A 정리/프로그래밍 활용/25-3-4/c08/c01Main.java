package c08;

public class c01Main {

	public static void main(String[] args) {

		c01Person hong = new c01Person();
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		System.out.printf("%s %d %f %f\n", hong.name,hong.age,hong.height,hong.weight);

	}

}
