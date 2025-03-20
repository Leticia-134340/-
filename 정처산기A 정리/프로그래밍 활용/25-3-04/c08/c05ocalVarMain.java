package c08;

//맴버 변수 : 클래스 내부 - 메서드 영역 바깥에서 생성
//			생성된 객체의 개별 정보 저장
//지역 변수 : 메서드 영역 내에서 (or 메서드 용욕 내의 {}범위에서 포
//			생성되는 변수(파라미터, 일반 변수)

//static 변수 : 동일 클래스로부터 만든 여러객체간 공유하는 멤버변수

class c05Simple{
	int num = 10; //멤버변수
	
	void Func1() {
		System.out.println("멤버변수 num : "+num);
		int num = 5;
		System.out.println("Func1's 지역변수 num : "+num);
		num++;
		this.num++;
	}

	void Func2() {
		System.out.println("멤버변수 num : "+num);
		if(true) {
			int num = 100;
			System.out.println("Func2if안 지역변수 num : "+num);
		}
		System.out.println("멤버변수 num : " + num);
		
		while(num<15) {
			int num=7;
			System.out.println("num : "+ num);
			num++;
		}

	}
	void Func3(int num) {
		this.num = num;
	}
}

public class c05ocalVarMain {

	public static void main(String[] args) {
		
		c05Simple obj = new c05Simple();
		obj.Func1();
		obj.Func2();

	}

}
