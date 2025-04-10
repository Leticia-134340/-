<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	System.out.println("pageContext : "+ pageContext);
	System.out.println("pageContext's get request : "+ pageContext.getRequest());
	System.out.println("pageContext's get response : "+ pageContext.getResponse());
	System.out.println("pageContext's get session : "+ pageContext.getSession());
	System.out.println("pageContext's get application : "+ pageContext.getServletContext());

	System.out.println("project path : " + pageContext.getServletContext().getContextPath());
	//프로젝트 경로를 아예 생략하거나 다 넣을 것 /test.jsp로 생략하면 경로가 바뀐다
	
%>

	<!-- 표현식 -->
	PROJECTPATH: <%=pageContext.getServletContext().getContextPath() %>
	<hr/>
	<!-- EL식 -->
	PROJECTPATH(EL): ${ pageContext.request.contextPath }


</body>
</html>