package c38.Domain.Service;

import java.sql.SQLException;

import c38.Domain.Dao.UserDaolmpl;
import c38.Domain.Dto.UserDto;

public class UserServicelmpl {
	
	//
	private UserDaolmpl userDao;
	
	//싱글톤 패턴
	private static UserServicelmpl instance;
	private UserServicelmpl() throws ClassNotFoundException, SQLException {
		userDao = UserDaolmpl.getInstance();
		System.out.println("[SERVICE] UserServicelmpl init...");
	};
	public static UserServicelmpl getInstance() throws ClassNotFoundException, SQLException {
		if(instance==null) 
			instance = new UserServicelmpl();
		return instance;
		
	}
	
	//회원가입(TX처리필요)
	public boolean userJoin(UserDto userDto) throws SQLException{
		
		return userDao.insert(userDto)>0;
		
		
	};
	
	//회원조회
	
	//회원정보 수정
	
	//회원 탈퇴
	
	//로그인
	
	//로그아웃

}
