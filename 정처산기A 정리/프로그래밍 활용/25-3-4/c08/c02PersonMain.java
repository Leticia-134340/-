package c08;

class c02Person{
	//속성
	String name;
	int age;
	float height;
	double weight;
}

public class c02PersonMain {

	public static void main(String[] args) {
		c01Person hong = new c01Person();
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		System.out.printf("%s %d %f %f\n", hong.name,hong.age,hong.height,hong.weight);

	}

}
