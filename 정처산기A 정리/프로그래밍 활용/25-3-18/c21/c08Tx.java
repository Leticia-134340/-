package c21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class c08Tx {

	//DB CONN DATA
	static String id = "root";
	static String pw = "8575";
	static String url = "jdbc:mysql://localhost:3306/testdb";
	
	//JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void main(String[] args) {
		
		try {
			//DB 연결코드
			Class.forName("com.mysql.cj.jdbc.Driver");		//사용할 클래스 명시
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			//
			System.out.println("INSERT 시작");
			conn.setAutoCommit(false);	//값이 한번에 입력되도록 함 만약 오류 뜨면 값이 들어가지 않음
			pstmt = conn.prepareStatement("insert into tbl_std values('a',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('b',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('a',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('d',1,'a')");
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("INSERT 종료");
			
		}catch(Exception e) {
			e.printStackTrace();
			try {conn.rollback();}catch(Exception e3) {}
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
			try {pstmt.close();}catch(Exception e2) {}
		}

	}

}
