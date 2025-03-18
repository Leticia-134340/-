package c22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class c02Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("192.168.16.22",7000);
		
		System.out.println("[CLIENT] 연결시작");
		OutputStream out =  client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in =  client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		//내용교환(q: 종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		
		while(true) {
			
			//CLIENT->SERVER 송신
			recv = din.readUTF();
			if(recv.equals("q")) 
				break;
			System.out.println("[SERVER(q:종료)]");
			
			//SERVER -> CLIENT(수신)
			System.out.println("[CLIENT] : "+recv);
			send = sc.nextLine();
			if(send.equals("q")) 
				break;
			
			dout.writeUTF(send);
			dout.flush();
			
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		System.out.println("[CLIENT] 연결 종료합니다");

	}

}
