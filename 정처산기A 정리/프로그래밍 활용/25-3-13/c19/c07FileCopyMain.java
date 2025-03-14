package c19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class c07FileCopyMain {

	public static void main(String[] args) throws Exception {

//		InputStream in = new FileInputStream("C:\\Users\\seoyeon\\Downloads\\[룬의 아이들] 윈터러 (원본).zip");
//		OutputStream out = new FileOutputStream("C:\\Users\\seoyeon\\Downloads\\COPY_[룬의 아이들] 윈터러 (원본).zip");
//		
//		//01 버퍼 미사용
//		while(true) {
//			int data = in.read();
//			if(data==-1)
//				break;
//			out.write((byte)data);
//			out.flush();
//		}
//		in.close();
//		out.close();
		
		//버퍼 사용
		
		InputStream in = new FileInputStream("C:\\Users\\seoyeon\\Downloads\\[룬의 아이들] 윈터러 (원본).zip");
		OutputStream out = new FileOutputStream("C:\\Users\\seoyeon\\Downloads\\COPY_[룬의 아이들] 윈터러 (원본).zip");
		
		//01 버퍼 미사용
		System.out.println("진행 중...");
		byte [] buff = new byte[4096];
		while(true) {
			int data = in.read(buff);
			if(data==-1)
				break;
//			out.write((byte)data);
			out.write(buff,0,data);
			out.flush();
		}
		in.close();
		out.close();
		System.out.println("종료");
		
	}

}
