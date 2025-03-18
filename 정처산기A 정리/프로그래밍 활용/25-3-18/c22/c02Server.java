package c22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class c02Server {

	public static void main(String[] args) throws IOException {
		//서버 소켓 생성
		ServerSocket server = new ServerSocket(7000); 	//192.168.16.70
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		//while문으로 close까지 감싸면 무한 통신이 된다
		//
		Socket client =  server.accept();
		
		//
		OutputStream out =  client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		//내용교환(q: 종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		while(true) {
			
			//SERVER->CLIENT 송신
			System.out.println("[SERVER(q:종료)]");
			send = sc.nextLine();
			if(send.equals("q")) 
				break;
			
			dout.writeUTF(send);
			dout.flush();
			//CLIENT -> SERVER (수신)
			recv = din.readUTF();
			if(recv.equals("q")) 
				break;
			
			System.out.println("[CLIENT] : "+recv);
			
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[SERVER] 연결 종료합니다");
		
		
	}

}
