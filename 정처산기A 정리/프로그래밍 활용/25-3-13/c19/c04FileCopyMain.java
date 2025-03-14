package c19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class c04FileCopyMain {

	private static String FileDir = "C:\\IOTEST\\";
	
	public static void main(String[] args) throws IOException {	//arg[0] 원본파일 args[1] 대상파일
		
		Reader fin = new FileReader("C:\\IOTEST\\test3.txt");
		int data=0;
		
		StringBuffer buffer = new StringBuffer();
		
		char[] buf = new char[1024];	//1024byte만큼씩 읽어낸다 
//		fin.read(buf);	//갯수 리턴
		
		long startTime = System.currentTimeMillis();
		while((data = fin.read(buf)) != -1) {
			
//			buffer.append((char)data);
			buffer.append(buf);
		}
		long endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("소요시간 : "+(endTime-startTime)+ "ms");
//		System.out.println(buffer);
		
		fin.close();
		

	}

}
