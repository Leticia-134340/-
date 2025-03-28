package c38.Tests.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import c38.Domain.Dao.BookDaolmpl;
import c38.Domain.Dao.UserDaolmpl;
import c38.Domain.Dto.BookDto;

class BookDaotest {

	@Test
	@Disabled
	void test1() throws ClassNotFoundException, SQLException {
		BookDaolmpl bookDaolmpl = BookDaolmpl.getInstence();
	}
	@Test
	void test2() throws Exception {
		BookDaolmpl bookDaolmpl = BookDaolmpl.getInstence();
		bookDaolmpl.insert(new BookDto("1","바람의 기억","혜리혜성","1234"));
	}

}
