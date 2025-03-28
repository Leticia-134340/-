package c38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import c38.Domain.Dto.UserDto;

public class UserDaolmpl {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String id="root";
	private String pw="8575";
	private String url="jdbc:mysql://localhost:3306/bookDB";
	
	//싱글톤 패턴처리
	private  static UserDaolmpl instance;
	private UserDaolmpl() throws ClassNotFoundException, SQLException {
		
		//DB 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("UserDaolmpl DB Connection Success");
		
	};
	public static UserDaolmpl getInstance() throws ClassNotFoundException, SQLException {
		if(instance==null) 
			instance= new UserDaolmpl();
		return instance;
		
	}
	
	//CRUD
	public int insert(UserDto userDto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, userDto.getUserid());
			pstmt.setString(2, userDto.getUsername());
			pstmt.setString(3, userDto.getPassword());
			pstmt.setString(4, "ROLE_USER");
			return pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDSO's INSERT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	public int update(UserDto userDto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDSO's UPDATE SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	public int delete(UserDto userDto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			
			return pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDSO's DELETE SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	//단건 조회
	public UserDto select(UserDto userDto) {
		return null;
	}
	//다건조회
	public List<UserDto> selectAll() {
		return null;
	}
}
