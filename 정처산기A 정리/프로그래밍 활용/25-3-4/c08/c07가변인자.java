package c08;

class c07Simple{
	
	int sum(int ...arg) {
		System.out.println(arg);
		int sum=0;
		for(int item : arg) {
			System.out.println(item);
			sum+=item;
		}
		return sum;
	}
}

public class c07가변인자 {

	public static void main(String[] args) {
		c07Simple ob = new c07Simple();
		ob.sum(10,20,30,40,50);
		System.out.println();
		ob.sum(10,20,30,40,50,80,90,100,110);

	}

}
