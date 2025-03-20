package cExDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cExDB {
	
	//DB CONN DATA
	
	private static String id = "root";
	private static String pw = "8575";
	private static String url = "jdbc:mysql://localhost:3306/tmpdb";
	
	//참조변수
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public static void conn() throws Exception {
		
		//DB 연결코드
	Class.forName("com.mysql.cj.jdbc.Driver");		//사용할 클래스 명시
	System.out.println("Driver Loading Success...");
	conn = DriverManager.getConnection(url,id,pw);
	System.out.println("DB CONNECTED...");
		
	}
	
	public static List<BookDto> selectAll() throws SQLException{
		//전체 조회
	//SQL 준비
	pstmt = conn.prepareStatement("select * from tbl_book");
	
	//SQL 실행
	rs = pstmt.executeQuery();
	
	List<BookDto> bookList = new ArrayList<>();
	
	if(rs!=null) {
		while (rs.next()) {
	        Long bookCode = rs.getLong("bookCode");
	        String bookName = rs.getString("bookName");
	        String publisher = rs.getString("publisher");
	        String isbn = rs.getString("isbn");
			
			bookList.add(new BookDto(bookCode, bookName, publisher, isbn));
			
		}	//더 이상 읽을 값이 없으면 탈출
	}
		return bookList;
	}

	public static BookDto select(Long bookCode) throws SQLException{
		
		pstmt = conn.prepareStatement("select * from tbl_book where bookCode = ?");
		pstmt.setLong(1, bookCode);
		
		rs = pstmt.executeQuery();
	    if (rs.next()) {
	        String bookName = rs.getString("bookName");
	        String publisher = rs.getString("publisher");
	        String isbn = rs.getString("isbn");
	        return new BookDto(bookCode, bookName, publisher, isbn);
	    }
		
		return null;
	}
	public static int insertBook(BookDto bookDto) throws SQLException{
		
		pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
		pstmt.setLong(1,bookDto.getBookCode());
		pstmt.setString(2,bookDto.getBookName());
		pstmt.setString(3,bookDto.getPublisher());
		pstmt.setString(4,bookDto.getIsbn());
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("[INFO] INSERT 성공!");
		else
			System.out.println("[ERROR] INSERT 실패!");
		
		return -1;
		
	}
	public static int updateBook(BookDto bookDto) throws SQLException{
		
		pstmt = conn.prepareStatement("update tbl_book set bookName =?, publisher = ?, isbn = ? where bookCode = ?");
		
		pstmt.setString(1, bookDto.getBookName());
		pstmt.setString(2, bookDto.getPublisher());
		pstmt.setString(3, bookDto.getIsbn());
		pstmt.setLong(4, bookDto.getBookCode());
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("[INFO] Update 성공!");
		else
			System.out.println("[ERROR] Update 실패!");
		
		return -1;
	}
	
	public static int deleteBook(Long bookDto) throws SQLException{
		
		pstmt = conn.prepareStatement("delete from tbl_book where bookCode = ?");
		
		pstmt.setLong(1, bookDto);
		
		int result = pstmt.executeUpdate();
		if(result>0)
			System.out.println("[INFO] Delete 성공!");
		else
			System.out.println("[ERROR] Delete 실패!");
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		try {
			//DBConn
			conn();
			//Tx start
//			conn.setAutoCommit(false);
			//Insert
			insertBook(new BookDto(1L, "도서명1","출판사명1","isbn-1"));
			insertBook(new BookDto(2L, "도서명2","출판사명2","isbn-2"));
			insertBook(new BookDto(3L, "도서명3","출판사명3","isbn-3"));
			//SelectAll
			List<BookDto> allBook = selectAll();
			System.out.println("selectAll : ");
			allBook.forEach(el->System.out.println(el));
			//Select
			BookDto dto = select(1L);
			System.out.println("select : "+dto);
			//Update
			dto.setBookName("수정도서명-2");
			dto.setPublisher("수정출판사명-2");
			int r1 = updateBook(dto);
			if(r1>0) {
				System.out.println("수정완료 : "+r1);
			}
			//Delete
			int r2 = deleteBook(2L);
			if(r2>0) {
				System.out.println("삭제완료 : "+r2);
			}
			//Tx End
//			conn.commit();
		}catch(Exception e) {
			//Tx RollbackAll
		}
		
	}


}
