<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	session.invalidate();
    
		System.out.println("<script> alert('Logout 성공! LOGIN PAGE로 이동합니다.');location.herf='login.jsp?message=Logout_Successful'</script>");

    
    
    
    %>