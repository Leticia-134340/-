<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	
<%
	/* request 내장객체 - 요청정보값 저장(HTTP Request Protocol의 구조형태 ) - 나중에 따로 정리 */

	String col1 = request.getParameter("열이름1");
	String col2 = request.getParameter("열이름2");
	String col3 = request.getParameter("열이름3");
	String col4 = request.getParameter("열이름4");
	String style = request.getParameter("Nav기본 스타일Code");
	System.out.printf("%s , %s , %s, %s \n","열이름1","열이름2","열이름3","열이름4");
	
%>
	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header style="background-color:<%="style"%>">
<nav>
<ul style="display: flex; justify-content: space-between;">
	<li class="li1"><%= col1 %></li>
	<li class="li2"><%= col2 %></li>
	<li class="li3"><%= col3 %></li>
	<li class="li4"><%= col4 %></li>
</ul>
</nav>
</header>


li1 = <%= col1 %>
li2 = <%= col2 %>
li3 = <%= col3 %>
li4 = <%= col4 %>

</body>
</html>