package c19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class c05FileInputStreamMain {

	public static void main(String[] args) throws IOException {
		
		InputStream fin = new FileInputStream("C:\\IOTEST\\data.xlsx");
		StringBuffer stringBuffer = new StringBuffer();
//		
//		//fin.read() 확인
//		long sTime = System.currentTimeMillis();
//		while(true) {
//			int data = fin.read();
//			if(data == -1) break;
//			
////			System.out.print((char)data);
//		}
//		long eTime = System.currentTimeMillis();
//		System.out.println("소요시간 : "+(eTime-sTime)+"ms");
//		fin.close();
		
		//1097ms
		
		
		//read([])
		byte [] buf = new byte[300];
		long sTime = System.currentTimeMillis();
		while(true) {
			int data = fin.read(buf);
			if(data == -1) break;
			
//			System.out.print((char)data);
		}
		long eTime = System.currentTimeMillis();
		System.out.println("소요시간 : "+(eTime-sTime)+"ms");
		fin.close();
		
		
		//buffer 추가 시 4096일 때 0이 된다

	}

}
