package c24;

import java.io.DataInputStream;

public class ClientRecvThread implements Runnable{
	
	//InputStream
	DataInputStream din;
	
	ClientRecvThread(DataInputStream din){
		this.din = din;
	}

	@Override
	public void run() {


		String recv;
		
		try {
			while(true) {
				
				//송신
				recv = din.readUTF();
				if(recv.equals("q"))
					break;
				System.out.println("[SERVER] : "+recv);
			}
		}catch(Exception e) {
			System.out.println("[EXCEPTION] 예외발생 ClientRecvThread 종료");
		}finally {
			try {din.close();}catch(Exception e2) {}
		}
		
	}

}
