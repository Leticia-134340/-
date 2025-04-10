<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 
		탑헤더나 네비, 푸터 등 화면 구성 요소들을 다른 파일에 설정해서 링크로 삽입해도 적용이 된다
		스타일도 가능하지만 오류가 날 경우 복구에 어려움이 있기 때문에 한 파일에 작성하는 것이 좋다
	 -->
	

<style>
	:root{}
	*{box-sizing: border-box;padding:10px;border:1px solid}
	a{}
	ul{}
	body{padding: 0; margin:0;}
	.wrapper{}
	.wrapper>header{min-height:100px;}
	.wrapper>header>.top-header{min-height:25px;}
	.wrapper>header>.nav{min-height:75px}
	.wrapper>main{
		min-height :calc(100vh - 100px - 250px);
		
		}
	.wrapper>main>section{}
	.wrapper>footer{min-height:250px}
</style>

</head>
<body>
	
	<div class="wrapper">
		<header>
			<!--  -->
			<%@ include file="./Layout/TopHeader.jsp" %>
			<!--  -->
			<%@ include file="./Layout/Nav.jsp" %>
			
		</header>
		<main>
			<section>MAIN>SECTION영역</section>
		</main>
			<!--  -->
			<%@ include file="./Layout/Footer.jsp" %>
	</div>
	
</body>
</html>