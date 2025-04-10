<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@page import="java.io.*" %>
	<%
		//response.sendRedirect("./02Request.jsp");	//경로설정(이 파일로 가라)
		
		
		//response.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT);
		
		//404 Error
		//response.sendError(HttpServletResponse.SC_NOT_FOUND,"해당 패이지를 찾을 수가 없습니다");
		
		//403 Error
		//response.sendError(HttpServletResponse.SC_FORBIDDEN,"접근금지");
		
		//5xx 에러
		//response.sendError(HttpServletResponse.SC_BAD_GATEWAY,"서버 장에 빌셍");
		
		//새로고침 반복
		//response.setIntHeader("Refresh",3);
		
		//Out Stream 추출
		/* ServletOutputStream bout = response.getOutputStream();
		bout.write('a');
		bout.write(98);	//b
		bout.flush();
		bout.close(); */
		
		PrintWriter o = response.getWriter();
		o.write("<h1>HELLO WORLD<h1/>");
		
	
	%>
	
	<%@page import="java.util.*" %>
	<%=new Date() %>


</body>
</html>