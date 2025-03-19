package c24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		//서버 소켓 생성
		ServerSocket server = new ServerSocket(7001); 	//192.168.16.70
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		//while문으로 close까지 감싸면 무한 통신이 된다
		//
		Socket client =  server.accept();
		
		//
//		System.out.println("CLIENT IP : "+ client.getInetAddress());
		OutputStream out =  client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		//
		ServerSendThread send = new ServerSendThread(dout);
		ServerRecvThread recv = new ServerRecvThread(din);
		
		//
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		//
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
		
		//자원제거
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[SERVER] 연결 종료합니다");
		
		
	}

}
