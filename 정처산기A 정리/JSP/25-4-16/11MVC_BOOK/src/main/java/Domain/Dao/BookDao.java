package Domain.Dao;

import java.util.List;

import Domain.Dto.BookDto;

public interface BookDao {

	int insert(BookDto bookDto) throws Exception;

	int update(BookDto userDto) throws Exception;

	int delete(BookDto userDto) throws Exception;
	//단건조회

	BookDto select(BookDto userDto);
	//다건조회
	public List<BookDto> selectAll() throws Exception;

	public List<BookDto> selectAll(int offset, int amount) throws Exception;
		
	public long count() throws Exception;

	BookDto select(String bookCode) throws Exception;
	
	
}