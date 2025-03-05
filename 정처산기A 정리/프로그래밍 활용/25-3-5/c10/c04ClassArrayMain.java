package c10;

class c04Person{
	
	String name;
	int age;
	//디폴트 생성자
	public c04Person(){}
	//모든인자 생성자
	public c04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//toString 재정의
	@Override
	public String toString() {
		return "c04Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class c04ClassArrayMain {

	public static void main(String[] args) {
		c04Person list[] = new c04Person[3]; //생성 아님 참조 변수임
		
		list[0] = new c04Person();
		list[0].name="홍길동";
		list[0].age=55;
		
		list[1] = new c04Person();
		list[1].name="김영희";
		list[1].age=35;
		
		list[2] = new c04Person();
		list[2].name="김범수";
		list[2].age=40;
		
		for(c04Person person : list)
			System.out.println(person);

	}

}
