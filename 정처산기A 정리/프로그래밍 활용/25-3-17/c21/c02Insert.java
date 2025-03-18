package c21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class c02Insert {

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
			//SQL 쿼리 준비
			String name = args[0];
			int age = Integer.parseInt(args[1]);
			String addr = args[2];
//			conn.prepareStatement("sql 문장");
//			pstmt=conn.prepareStatement("insert into tbl_std values(?,?,?)");
//			pstmt.setString(1, name);
//			pstmt.setInt(2, age);
//			pstmt.setString(3, addr);
//			String name = "청길동";
//			int age = 10;
//			String addr = "대구";
			
			pstmt=conn.prepareStatement("insert into tbl_std values('"+name+"',"+age+",'"+addr+"')");
																	//이렇게 해도 값이 삽입이 된다 문자열은 홑따옴표도 붙일 것			
			
			
			//SQL 실행
			int result = pstmt.executeUpdate();
			
			if(result>0)
				System.out.println("INSERT 성공");
			else
				System.out.println("INSERT 실패");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {conn.close();}catch(SQLException e) {e.printStackTrace();}
		}

	}

}
