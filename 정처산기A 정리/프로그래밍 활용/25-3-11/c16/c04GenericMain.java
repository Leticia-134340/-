package c16;

class Animal{
	String name;
}
class Panda extends Animal{

	public Panda(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
	
}
class Tiger extends Animal{
	
	public Tiger(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
	
}

public class c04GenericMain {

	//Generic - 지정된 것만 가능
	public static <T> void PrintByGeneric(T [] arr) {
		for(T el : arr)
			System.out.println(el);
	}
	//Object - 전부 가능
	public static void PrintByObject(Object [] animal) {
		for(Object el : animal) {
			System.out.println(el);
		}
	}
	
	public static void main(String[] args) {
		
		Tiger arr1 [] = {new Tiger("시베리안 호랑이"),new Tiger("96햄찌"),new Tiger("신사동호랭이")};
		PrintByGeneric(arr1);
		
		Panda arr2 [] = {new Panda("래서판다"),new Panda("제주도 귤"),new Panda("동그란 고양이")};
		PrintByGeneric(arr2);
		
		Object arr3 [] = {new Panda("중국판다"), new Tiger("백호"),new Panda("푸바오")};
		PrintByObject(arr3);
		
	}

}
