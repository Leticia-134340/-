package c15;

public class c02ArrayIndexBoundExceptionMain {

	public static void main(String[] args) {
		int [] arr = {10, 20, 30};
		
			try {
				
				for(int i=0;i<4;i++)
					System.out.println(arr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외처리 : "+e);
			}
		
		System.out.println("HELLO WORLD");

	}

}
