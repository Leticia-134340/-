package c11;

class ShopService{
	int obj1;
	int obj2;
	
	//toString
	@Override
	public String toString() {
		return "ShopService [obj1=" + obj1 + ", obj2=" + obj2 + "]";
	}
	
	//싱글톤 패턴 구조
	private static ShopService instance;
	private ShopService() {}
	public static ShopService getInstance() 
	{
		if(instance == null) 
			instance = new ShopService();
		return instance;
	}
}

public class C05Ex {
	public static void main(String[] args) {
		//---------------------------------------
		//Practice
		//---------------------------------------
		//shopService 객체를 싱글톤으로 만들어 보세요 
		//ShopServiceExample 클래스에서 shopService 의 getInstance() 메소드로 싱글톤을 얻을 수 있도록
		//ShopService 클래스를 작성해보세요
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체 입니다.");
		}
	}
}
