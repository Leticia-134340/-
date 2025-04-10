<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Join Form</h1>
	<div >
		${param.message}
	</div>
	<form action="${pageContext.request.contextPath}/C06/03/join.jsp" method="post">
		<div>
			<label>아이디 : </label><span>${userid_msg}</span><br/>
			<input type="text" name="userid">
		</div>
		<div>
			<label>비밀번호 : </label><span>${password_msg}</span><br>
			<input type="text" name="password">
		</div>
		<div>
			<label>휴대전화 번호 : </label><span>${phone_msg}</span><br>
			<input type="number" name="phone">
		</div>
		<div>
			<label>이메일 : </label><span>${email_msg}</span><br>
			<input type="text" name="email">
		</div>
		<button>가입하기</button>
	
	</form>

</body>
</html>















