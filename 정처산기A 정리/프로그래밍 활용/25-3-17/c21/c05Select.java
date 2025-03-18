package c21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class c05Select {

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
			//
			Class.forName("com.mysql.cj.jdbc.Driver");		//사용할 클래스 명시
			System.out.println("Driver Loading Success...");
			//
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			//SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_std");
			
			//SQL 실행
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {	//다음 행으로 이동
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getString("age")+" ");
					System.out.print(rs.getString("addr")+"\n");
					
				}	//더 이상 읽을 값이 없으면 탈출
			}
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			
			try {rs.close();}catch(SQLException e) {e.printStackTrace();}
			try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}
			try {conn.close();}catch(SQLException e) {e.printStackTrace();}
		}

	}

}
