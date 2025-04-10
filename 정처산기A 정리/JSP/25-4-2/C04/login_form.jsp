<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<header>
			<!-- top-header insert 지시자 이용해서 가져오기 -->
			<%@ include file = "./Layout/TopHeader.jsp" %>
			<!-- nav Insert 지시자 이용해서 가져오기 -->
			<%@ include file = "./Layout/Nav.jsp" %>
		</header>
		<main>
			<section>
				<!--  
						form태그로 
						
						1. myinfo.jsp(생성)
						2. vailadtionCheck.jsp(기존)
						3. dbUtils.jsp(기존)
						4. myinfo.jsp(내용표시)
					-->
				<form action="Login.jsp">
					<input type="text" name="userid" /><br> 
					<input type="text"name="password" /><br> 
					<input type="submit" value="회원가입" />
				</form>
			</section>

		</main>

		<footer>
			<!-- footer insert 지시자 이용해서 가져오기 -->
			<%@ include file = "./Layout/Footer.jsp" %>
		</footer>
	</div>
</body>
</html>