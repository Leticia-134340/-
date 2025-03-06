package c11;

class c01Simple{
	static int num1;
	int num2;
	
	//static : 클래스 내에 멤버에 적용하는 경우
	//해당 클래스로 객체 생성 시 모든 객체 간의 공유되는 멤버로 지정
	//클래스 이름으로도 static 멤버에 접근이 가능
	
	public c01Simple() {
		num1 = 0;
		num2 = 0;
	}

	public c01Simple(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "c01Simple [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
}

public class c01StaticMain {

	public static void main(String[] args) {//공유 변수
		
		
		c01Simple ob1 = new c01Simple();
		c01Simple ob2 = new c01Simple();
		
		c01Simple.num1=100;
		System.out.println(c01Simple.num1);

		System.out.println(ob1);
		System.out.println(ob2);

	}

}
