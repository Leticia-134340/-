package Tests;

import org.junit.jupiter.api.Test;

import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

class ServiceTests {

	@Test
	void test() throws Exception {
		BookServiceImpl.getInstance().bookRegistration(new BookDto("222","Universe","테라","134-340"));
	}

}
