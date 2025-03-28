package c38.Tests.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Spring;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import c38.Controller.FrontController;

class ControllerTests {

	FrontController fc = FrontController.getInstance();
	@Test
	
	void test() {
		//View에서 요청 정보 담기
		Map<String,Object> params = new HashMap();
		params.put("endPoint","/user");	//endPoint
		params.put("serviceNo",1);		//ServiceNo
		//회원가입-인자 전달
//		params.put("userid", "user555");
//		params.put("username", "홍길동");
//		params.put("password", "1234");
		params.put("userid", "ccccc");
		params.put("username", "황길동");
		params.put("password", "2431");
		
		
		//요청하기
		Map<String, Object> response = fc.execute(params);
		//응답확인
		for(String key : response.keySet()) {
			System.out.println(key + " : "+ response.get(key));
		}
	}
	@Test
	@Disabled
	void test_99() {
		//View에서 요청정보 담기
		Map<String,Object> params = new HashMap();
//		params.put("endPoint", "/book");//endPoint
//		params.put("serviceNo", 1);	//ServiceNo
		//회원가입-인자 전달
		
//		params.put("bookcode", "12345678");
//		params.put("bookname", "바람의 날개");
//		params.put("publisher", "은하출판사");
//		params.put("isbn", "1234");
		//요청하기
		Map<String,Object> response =  fc.execute(params);
		
		//응답확인
		for(String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
	}

}
