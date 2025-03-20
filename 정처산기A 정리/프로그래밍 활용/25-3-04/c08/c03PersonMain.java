package c08;

class c03Person{
	//속성
	String name;
	int age;
	float height;
	double weight;
	//기능
	void talk() {System.out.printf("%s 님이 말합니다.\n",this.name);}
	void walk() {System.out.printf("%s 님이 걷습니다.\n",this.name);}
	//속성 정보 확인
	void showInfo() {
		System.out.printf("%s %d %f %f\n", this.name,this.age,this.height,this.weight);
	}
	//객체정보 확인(toString)
	@Override
	public String toString() {
		return "c03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
}

public class c03PersonMain {

	public static void main(String[] args) {
		c03Person hong = new c03Person();
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		hong.talk();
		hong.walk();
		hong.showInfo();
		
		System.out.println(hong.toString());
		System.out.println(hong);

	}

}
