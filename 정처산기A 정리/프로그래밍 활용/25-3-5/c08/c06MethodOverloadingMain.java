package c08;

class c06Simple{
	int sum(int x , int y) {
		System.out.println("int sum(int x , int y)");
		return x + y;
	}
	int sum(int x , int y, int z) {
		System.out.println("int sum(int x , int y, int z)");
		return x + y + z;
	}
	int sum(double x , double y, double z) {
		System.out.println("int sum(double x , double y, double z)");
		return (int)(x + y + z);
	}
}

public class c06MethodOverloadingMain {

	public static void main(String[] args) {
		c06Simple obj = new c06Simple();
		obj.sum(10, 20);
		obj.sum(10, 20, 30);
		obj.sum(10.5 , 20.5, 30.5);
		c06Simple obj2 = new c06Simple();

	}

}
