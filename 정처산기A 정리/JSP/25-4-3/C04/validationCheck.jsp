<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./errors.jsp"%>

<%@page import="C04.*" %>
<%

	//request로부터 전달받은 파라미터 꺼내서 System.out 확인
	//받은 username,password 값이 null인지여부를 체크(String API trim()  + isEmpty() 이용)
	//에러 발생 시 에러페이지로 전달(Error.jsp)
	
	
	//url 선별 serviceNo 선별 -> 유효성 체크
	
	
	String url = (String)request.getAttribute("url");
	Integer serviceNo = (Integer)request.getAttribute("serviceNo");
	
	if(url.contains("/join")){
		UserDto userDto = (UserDto)request.getAttribute("userDto");
		isValid(userDto);
		
	}else if(url.contains("/myinfo")){
		//myinfo
		String userid = request.getParameter("userid");
		isValid(userid);
	}
	
    request.getRequestDispatcher("./dbUtil.jsp").forward(request, response);
%>

<%! 
	void isValid(UserDto userDto) throws Exception{
		System.out.println("[VALIDATION CHECK] userDto : "+userDto);
		if(userDto == null)
			throw new Exception("유저 정보를 입력하세요");
	    if(userDto.getUserid().trim().isEmpty())
			throw new Exception("유저 아이디를 입력하세요");
	    if(userDto.getPassword().trim().isEmpty())
			throw new Exception("비밀번호를 입력하세요");
	    if(userDto.getRole().trim().isEmpty())
			throw new Exception("유저 역할을 지정하세요");
	}

	void isValid(String userid) throws Exception{
		if(userid.trim().isEmpty())
			throw new Exception("유저 정보를 입력하세요");
	}


%>