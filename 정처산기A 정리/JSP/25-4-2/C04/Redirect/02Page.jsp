<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.*" %>
    
        
    <%
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	System.out.println("--------------02PAGE--------------");
    	System.out.println("username : "+username);
    	System.out.println("password : "+password);
    	System.out.println("----------------------------------");
    
    	request.setAttribute("02Page","02PageValue");
    	/* REDIRECT */
    	response.sendRedirect("./03Page.jsp?hobby="+URLEncoder.encode("등산","UTF-8"));
    	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>