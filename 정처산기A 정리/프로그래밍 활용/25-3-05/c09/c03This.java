package c09;

// this
// 클래스 내에서 사용되는 예약어
// 생성되는 객체의 위치정보(메모리주소-해시코드값)을 확인하는데 사용

// this : 멤버변수와 지역변수 구별에 사용
// this : 다른생성자 호출 사용

class c03Simple{
	int x;
	int y;
	
	c03Simple(){
		this(0,0);
		System.out.println("c03Simple()...생성자 호출");
	}
	c03Simple(int x){
		this(x,0);
		System.out.println("c03Simple(int x)...생성자 호출");
		this.x = x;
	}
	c03Simple(int x, int y){
		System.out.println("c03Simple(int x, int y)...생성자 호출");
		this.x = x;
		this.y = y;
	}
	
	c03Simple getThis(){
		return this;
	}
}

public class c03This {

	public static void main(String[] args) {
		
		c03Simple ob = new c03Simple();
		System.out.println(ob);
		System.out.println(ob.getThis());

	}

}
