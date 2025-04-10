package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	//싱글톤 
	private static DBUtils instance;
	private DBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static DBUtils getInstance() throws Exception {
		if(instance==null)
			instance = new DBUtils();
		return instance;
	}
	
	//강사 테이블 조회
	public List<TeacherDto> selectAllTeacher() throws Exception{
		String sql="select * from tbl_teacher_202201";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		List<TeacherDto> list = new ArrayList<>();
		TeacherDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new TeacherDto();
				dto.setTeacher_code(rs.getString(1));
				dto.setTeacher_name(rs.getString(2));
				dto.setClass_name(rs.getString(3));
				dto.setClass_price(rs.getInt(4));
				dto.setTeacher_regist_date(rs.getString(5));
				list.add(dto);
			}
		}
		return list;
	}
	
	
	public List<MemberDto> selectAllMember() throws Exception{
		
		String sql="select * from tbl_member_202201";
		pstmt=conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		MemberDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new MemberDto();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setGrade(rs.getString(5));
				list.add(dto);
			}
			
		}
		rs.close();
		pstmt.close();
		return list;
		
	}
	
	public List<ClassDto> selectAllClass() throws Exception{
		String sql = "select * from tbl_class_202201";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		List<ClassDto> list = new ArrayList<>();
		ClassDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new ClassDto();
				dto.setRegist_month(rs.getString(1));
				dto.setC_no(rs.getString(2));
				dto.setClass_area(rs.getString(3));
				dto.setTuition(rs.getString(4));
				dto.setTeacher_code(rs.getString(5));
				list.add(dto);
				
			}
			
		}
		rs.close();
		pstmt.close();
		return list;
		
		
	}
	
	public int insertClass(ClassDto classDto) throws Exception {
		
		pstmt = conn.prepareStatement("insert into tbl_class_202201 values(?,?,?,?,?)");
		pstmt.setString(1, classDto.getRegist_month());
		pstmt.setString(2, classDto.getC_no());
		pstmt.setString(3, classDto.getClass_area());
		pstmt.setString(4, classDto.getTuition());
		pstmt.setString(5, classDto.getTeacher_code());
		
		int result = pstmt.executeUpdate();
		
		conn.commit();
		pstmt.close();
		return result;
		
	}
	
	public List<Join1Dto> selectAllJoin1(){
		String sql = "select C.regist_month,"
		
		
	}


	
	
	
	
	
/*	
//	select M.M_NO,M.M_NAME,P.P_NAME,M.P_SCHOOL,M.M_JUMIN,M.M_CITY,P.P_TEL1,P.P_TEL2,P.P_TEL3
//	from TBL_MEMBER_202005 M
//	join TBL_PARTY_202005 P
//	on M.P_CODE=P.P_CODE;
	public List<MemberDto> selectAllMember() throws Exception{
		String sql="select M.M_NO,M.M_NAME,P.P_NAME,M.P_SCHOOL,M.M_JUMIN,M.M_CITY,P.P_TEL1,P.P_TEL2,P.P_TEL3"
				+ " from TBL_MEMBER_202005 M"
				+ " join TBL_PARTY_202005 P"
				+ " on M.P_CODE=P.P_CODE"
				;
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		if(rs!=null) {
			
			while(rs.next()) {
				dto = new MemberDto();	
				dto.setM_no(rs.getString(1));
				dto.setM_name(rs.getString(2));
				dto.setP_name(rs.getString(3));
				dto.setP_school(rs.getString(4));
				dto.setM_jumin(rs.getString(5));
				dto.setM_city(rs.getString(6));
				dto.setP_tel1(rs.getString(7));
				dto.setP_tel2(rs.getString(8));
				dto.setP_tel3(rs.getString(9));
				list.add(dto);
			}
		}
		
		pstmt.close();
		rs.close();
		return list;
	}

	
	public int insertVote(VoteDto dto) throws Exception {
		
		pstmt = conn.prepareStatement("insert into TBL_VOTE_202005 values(?,?,?,?,?,?)");
		pstmt.setString(1, dto.getV_jumin());
		pstmt.setString(2, dto.getV_name());
		pstmt.setString(3, dto.getM_no());
		pstmt.setString(4, dto.getV_time());
		pstmt.setString(5, dto.getV_area());
		pstmt.setString(6, dto.getV_confirm());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	public List<VoteDto> selectAllVote() throws Exception{
		
		String sql="select M.M_no,m.m_name, count(*)\r\n"
				+ "from tbl_member_202005 M\r\n"
				+ "JOIN tbl_vote V\r\n"
				+ "on M.M_no=v.m_no\r\n"
				+ "group by m.m_no,M.M_name\r\n"
				+ "order by count(*) desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<VoteDto> list = new ArrayList();
		VoteDto dto= null;
		if(rs!=null) {
			
			while(rs.next()) {
				dto = new VoteDto();
				dto.setV_jumin(sql);
				dto.setV_name(sql);
				dto.setM_no(sql);
				dto.setV_time(sql);
				dto.setV_area(sql);
				dto.setV_confirm(sql);
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;*/
		
	
	
	
	
}







