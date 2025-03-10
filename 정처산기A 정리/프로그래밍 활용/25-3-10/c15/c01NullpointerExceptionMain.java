package c15;

public class c01NullpointerExceptionMain {

	public static void main(String[] args) {
		
		try {
			
			String str = null;
			System.out.println(str.toString());	//null 값이라서 예외가 발생하여 수행이 안됨
			
		}catch(NullPointerException e){
			System.out.println("예외발생 : "+e);
			//System.out.println(e.getCause());
			//System.out.println(e.toString());
			//System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
		System.out.println("HELLOWORLD");
		System.out.println("HELLOWORLD");

	}

}
