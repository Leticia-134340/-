package c13;

interface Remocon{
	int MAX_VOL = 100;
	int MIN_VOL = 0;
	void setVolume(int vol);
	//TV, Radio 각각 메서드 완성
	//MAX_VOL, MIN_VOL 적용해서 최대 최소 제한
	//vol 값이 100을 초과할 떄는 최대 볼륨값으로 적용(print : 최대볼륨으로 설정합니다)
	//vol 값이 0미만일 떄는 최소 볼륨값으로 적용(print : 최소볼륨으로 설정합니다)
	//0<=vol<=100 사이면 멤버변수 vol에 저장해주시고 현재볼륨 출력(print: 현재볼륨:n)
	void powerOn() {
		
	};		//abstract function
	void powerOff() {
		
	};	//abstract function
}
interface Browser{
	void SearchURL(String url);
}
class TV implements Remocon{

	
	@Override
	public void powerOn() {
		System.out.println("TV를 켭니다");
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("TV를 끕니다");
		
	}

	@Override
	public void setVolume(int vol) {
		if(vol>MAX_VOL) {
			vol=MAX_VOL;
			System.out.println("최대볼륨");
		}else if(vol<MIN_VOL) {
			vol=MIN_VOL;
			System.out.println("최소볼륨");
		}else {
			this.vol=vol;
			System.out.println("현재볼륨 : "+ this.vol);
		}
		
	}
	
}
class SmartTV extends TV implements Browser{

	@Override
	public void SearchURL(String url) {
		System.out.println(url + "로 이동합니다");
		
	}
	
}
class Radio implements Remocon{

	@Override
	public void powerOn() {
		System.out.println("라디오를 킵니다");

		
	}

	@Override
	public void powerOff() {
		System.out.println("라디오를 끕니다");
		
	}

	@Override
	public void setVolume(int vol) {
		// TODO Auto-generated method stub
		
	}
	
}

public class c03InterfaceMain {
	
	public static void TurnOn(Remocon controllar) {
		controllar.powerOn();
	}
	public static void TurnOff(Remocon controllar) {
		controllar.powerOff();
	}
	
	public static void ChangeVolumn(Remocon controllar, int vol) {
		controllar.setVolume(vol);
	}
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);
	}
	public static void main(String[] args) {
		TV tv1 = new TV();
		SmartTV smartTv1 = new SmartTV();
		Radio radio1 = new Radio();
		
		TurnOn(tv1);
		TurnOn(tv1);
		TurnOn(radio1);
		
		ChangeVolumn(tv1,90);
		ChangeVolumn(radio1,101);
		
		Internet(smartTv1,"www.naver.com");
		TurnOff(tv1);
		TurnOff(radio1);
		
	}
}
