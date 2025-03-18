package c20;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class C03DataInoutStreamMain {

	public static void main(String[] args) throws Exception{
		
//		FileOutputStream out = new FileOutputStream("C:\\IOTEST\\test3.txt");
//		DataOutputStream dout = new DataOutputStream(out);
//		dout.writeUTF("홍길동");
//		dout.writeDouble(95.5);
//		dout.writeInt(100);
//		dout.flush();
//		dout.close();
		
		FileInputStream in = new FileInputStream("C:\\IOTEST\\test3.txt");
		DataInputStream din = new DataInputStream(in);
		String name= din.readUTF();		//문자열 데이터 불러오기
		System.out.println(name);
		double weight = din.readDouble();	//실수 데이터 불러오기
		System.out.println(weight);
		int data = din.readInt();	//숫자 데이터 불러오기
		System.out.println(data);
		
	}		//불러올 데이터 순서대로 적어야한다
}
