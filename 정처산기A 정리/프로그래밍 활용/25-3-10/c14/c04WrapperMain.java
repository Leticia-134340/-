package c14;

//신경 쓸 것 null 체크에 유리

public class c04WrapperMain {

	public static void main(String[] args) {
		
		//Boxing(기본자료형 -> Wrapper Class)
		Integer ob1 = new Integer(100); //빗금은 버전이 넘어가면서 권장하지 않는 코드다. 쓸 순 있다
		Integer ob2 = new Integer("100");
		Integer ob3 = Integer.valueOf("300"); //정수형으로 자동 변환
		System.out.println(ob1 + ob2 + ob3);
		
		//UnBoxing
		int n1 = ob1.intValue();
		int n2 = ob2.intValue();
		int n3 = ob3.intValue();
		System.out.println(n1 + n2 + n3);
		
		//Auto Boxing
		Integer ob4 = 100;
		
		int aa = 100;
		if(ob4==null) {
			
		}
//		if(aa==null) {
//			
//		}
		
		int n4 = ob1 + ob2 + ob3;

	}

}
