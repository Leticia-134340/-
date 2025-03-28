package c38.Controller;

import java.util.HashMap;
import java.util.Map;

import c38.Domain.Dto.BookDto;

public class BookController implements SubController {

	Map<String,Object> response;
	
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute invoke...!");
		//00
		response = new HashMap();
		
		Integer serviceNo =(Integer)params.get("serviceNo");
		if(serviceNo==null) {
			response.put("status", false);
			response.put("message","유효하지 않은 서비스 요청입니다");
			return response;
		}
		switch(serviceNo) {
			case 1:
				System.out.println("[SC] 도서 등록 요청 확인");
				//파라미터 받기
				String bookcode = (params.get("bookcode")!=null)?(String)params.get("bookcode"):null;
				String bookname = (params.get("bookname")!=null)?(String)params.get("bookname"):null;
				String publisher = (params.get("publisher")!=null)?(String)params.get("publisher"):null;
				String isbn = (params.get("isbn")!=null)?(String)params.get("isbn"):null;
				BookDto bookDto = new BookDto(bookcode,bookname,publisher,isbn);
				
				//유효성 검증
				boolean isOk=isValid(bookDto);
				System.out.println("[No-1 도서 등록] 유효성 검증 확인 : "+isOk);
				if(!isOk) {
					response.put("status", false);
					return response;
				}
				break;
			case 2:
				System.out.println("[SC] 도서 조회 요청 확인");
				break;
			case 3:
				System.out.println("[SC] 도서 수정 요청 확인");
				break;
			case 4:
				System.out.println("[SC] 도서 삭제 요청 확인");
				break;
			default :
				System.out.println("[SC] 잘못된 서비스번호 요청 확인");
				response.put("status", false);
				response.put("message", "잘못된 서비스번호 요청입니다.");
		}
		
		return response;
	}

	private boolean isValid(BookDto bookDto) {
		if(bookDto.getBookcode()==null || bookDto.getBookcode().length()!=8) {
			response.put("error", "bookcode의 길이는 8자만 됩니다");
			System.out.println("[INVALID] bookcode의 길이는 8글자만 됩니다");
		}
		if(bookDto.getBookname().length()>255) {
			response.put("error", "bookname은 255자를 넘을 수 없습니다");
			System.out.println("[INVALID] bookname은 255자를 넘을 수 없습니다");
			return false;
		}
		return true;
	}

}










