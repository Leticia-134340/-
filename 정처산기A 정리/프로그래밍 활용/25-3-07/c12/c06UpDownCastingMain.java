package c12;

class Super{
	int n1;
}
class Sub extends Super{
	int n2;
}

public class c06UpDownCastingMain {

	public static void main(String[] args) {
		
		//NoCasting (자료형의 일치)
//		Super ob1 = new Super();
//		ob1.n1 = 10;
//		Sub ob2 = new Sub();	//자식 노드를 가리키는 참조변수
//		ob2.n1 = 10;
//		ob2.n2 = 10;
		
		
		//UpCasting(상위클래스 참조변수 = 하위클래스형 객체)(자동형변환)
		//상속관계로 연결된 모든 하위객체를 연결할 수 있다
//		Super ob3 = new Sub(); 	//하위 클래스는 상위 클래스의 요소에 자신의 요소가 더해지기 때문에 공간이 더 넓어진다
								//그래서 상위에서 하위로의 자동형변환이 일어난다  //메모리 공간이 침범 당하느냐 아니냐의 문제
//		ob3.n1 = 100;
//		ob3.n2 = 200;	//접근 불가
//		Super ob4 = ob2;
//		ob4.n1 = 100;	//상위 클래스에서 하위로 형변환이 되는 경우 다른 메모리 공간이 있어도
						//상위 클래스에 해당하는 요소만 접근이 가능하다
//		ob4.n2 = 200;	//접근 불가
		
		// UpCasting을 쓰는 이유는 상위 클래스를 하위로 자유자제로 연결하기 위함이다 그렇지 않으면 연결이 복잡해진다
		
		//DownCasting(하위클래스 참조변수 = 상위클래스형 객체)(강제형변환)
		//Upcasting 된 상태에서 확장된 멤버에 접근하기 위한 용도
//		Sub ob5 = ob1;	//실재 공간이 없는 메모리까지 가리킬 가능성이 있기 떄문에 오류를 띄운다. 컴파일러는 못 잡지만 실행 때 
						//오류를 띄운다
//		Sub ob6 = (Sub)ob3; // 업캐스팅 된 ob3을 다시 다운 캐스팅하는 것

	}

}
