package c21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class c01DBConn {

	public static void main(String[] args) {
		
		//DB CONN DATA
		String id = "root";
		String pw = "8575";
		String url = "jdbc:mysql://localhost:3306/testdb";	//DB설치 위치
		
		//JDBC참조 변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//사용할 클래스 명시
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {conn.close();}catch(SQLException e) {e.printStackTrace();}
		}

	}

}
