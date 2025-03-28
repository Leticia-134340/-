package c38.Tests.Dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import c38.Domain.Dao.UserDaolmpl;
import c38.Domain.Dto.UserDto;

class DaoTests {

	@Test
	@Disabled
	void test1() throws ClassNotFoundException, SQLException{

		UserDaolmpl userDaolmpl = UserDaolmpl.getInstance();
		
	}
	@Test
	void test2() throws Exception{
		
		UserDaolmpl userDaolmpl = UserDaolmpl.getInstance();
		userDaolmpl.insert(new UserDto("aaa","홍길동","1234",""));
		
	}
	@Test
	@Disabled
	void test3() throws ClassNotFoundException, SQLException{
		
		UserDaolmpl userDaolmpl = UserDaolmpl.getInstance();
		
	}

}
