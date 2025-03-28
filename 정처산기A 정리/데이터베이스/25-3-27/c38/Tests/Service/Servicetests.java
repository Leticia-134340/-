package c38.Tests.Service;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import c38.Domain.Dto.UserDto;
import c38.Domain.Service.UserServicelmpl;

class Servicetests {
	

	@Test
	
	void test() throws ClassNotFoundException, SQLException {
		
		UserServicelmpl userService = UserServicelmpl.getInstance();
		
		userService.userJoin(new UserDto("bbb","청길동","2134","ROLE_USER"));
		
	}

	@Test
	@Disabled
	void test_1() {
		
	}

}
