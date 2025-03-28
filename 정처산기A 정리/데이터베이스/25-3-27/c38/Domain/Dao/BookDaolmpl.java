package c38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import c38.Domain.Dto.BookDto;

public class BookDaolmpl {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String id="root";
	private String pw="8575";
	private String url="jdbc:mysql://localhost:3306/bookDB";
	
	//싱글톤
	private static BookDaolmpl instance;
	private BookDaolmpl() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("BookDaolmpl DB Connection Success");
	};
	public static BookDaolmpl getInstence() throws ClassNotFoundException, SQLException {
		if(instance==null)
			instance = new BookDaolmpl();
		return instance;
	}
	
	//CRUD
	public int insert(BookDto bookDto) throws Exception {
		try {
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookDto.getBookcode());
			pstmt.setString(2, bookDto.getBookname());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setString(4, bookDto.getIsbn());
			return pstmt.executeUpdate();
			
					
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDTO's INSERT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	public int update(BookDto bookDto) throws Exception {
		try {
			pstmt = conn.prepareStatement("");
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDTO's UPDATE SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	public int delete(BookDto bookDto) throws Exception {
		try {
			pstmt = conn.prepareStatement("");
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDTO's DELETE SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	public BookDto select(BookDto bookDto) {
		return null;
	}
	public List<BookDto> selectAll() {
		return null;
	}
	
	
	

}
