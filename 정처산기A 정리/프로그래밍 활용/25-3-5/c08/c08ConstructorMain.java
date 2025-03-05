package c08;

//생성자 메서드
//객체 생성시 한번만 호출되는 메서드
//생성된 객체 내에서는 사용이 불가능
//객체 생성 시에 필요한 메모리 공간 형성과 "초기값 부여"에 사용
//생성자 메서드 이름은 클래스 이름과 동일하며 반환자료형은 가지지 않는다

//생성자 함수를 클래스 내에 명시하지 않으면(코드 삽입 x) 컴파일러에 의해 주입되는
//생성자가 있는데 이를 디폴트 생성자라 한다

class c08Simple{
	//속성
	int n1;
	double n2;
	boolean n3;
	String n4;
	
	c08Simple(){
		System.out.println("c08Simple() 생성자 호출 - 디폴트생성자");
	}
	
	c08Simple(int n1) {
		this.n1=n1;
		System.out.println("c08Simple(int n1) 생성자 호출!");
	}
	c08Simple(int n1,double n2) {
		this.n1=n1;
		this.n2=n2;
		System.out.println("c08Simple(int n1, double n2) 생성자 호출!");

	}
	c08Simple(int n1, double n2, boolean n3) {
		this.n1=n1;
		this.n2=n2;
		this.n3=n3;
		System.out.println("c08Simple(int n1, double n2, boolean n3) 생성자 호출!");

	}
//	c08Simple(int n1, double n2, boolean n3, String n4) {
//		this.n1=n1;
//		this.n2=n2;
//		this.n3=n3;
//		this.n4=n4;
//		System.out.println("c08Simple(int n1, double n2, boolean n3, String n4) 생성자 호출!");
//
//	}
	
	public c08Simple(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}
	//toString재정의
	@Override
	public String toString() {
		return "c08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}
	
}

public class c08ConstructorMain {

	public static void main(String[] args) {
		c08Simple ob0 = new c08Simple();
		
		c08Simple ob1 = new c08Simple(10);
		c08Simple ob2 = new c08Simple(10, 10.5);
		c08Simple ob3 = new c08Simple(10, 10.5, true);
		c08Simple ob4 = new c08Simple(10, 10.5, true, "홍길동");
		
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println(ob3);
		System.out.println(ob4);

	}

}
