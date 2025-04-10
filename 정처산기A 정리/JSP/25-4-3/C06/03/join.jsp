<%@page import="javax.script.ScriptContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//값 가져오기
		String userid = request.getParameter("userid");    
		String password = request.getParameter("password");    
		String phone = request.getParameter("phone");    
		String email = request.getParameter("email");    
    	
		//유효성 검사
		if(userid.isEmpty()){
			request.setAttribute("userid_msg", "아이디를 입력하세요");
		}
		if(password.isEmpty()){
			request.setAttribute("password_msg", "비밀번호를 입력하세요");
		}
		if(phone.isEmpty()){
			request.setAttribute("phone_msg", "전화번호를 입력하세요");
		}
		if(password.isEmpty()){
			request.setAttribute("email_msg", "이메일을 입력하세요");
		}
		if(userid.isEmpty()||password.isEmpty()||phone.isEmpty()||email.isEmpty()){
			request.getRequestDispatcher("./join_form.jsp").forward(request,response);
		}
		
		//01 ID 중복 확인(DB 조회 - 생략)
		if(userid.equals("admin")){
			request.setAttribute("userid_msg", "이미 존재하는 아이디입니다");
			request.getRequestDispatcher("./join_form.jsp").forward(request,response);
			return ;
		}
		if(phone.equals("01012341234")){
			request.setAttribute("phone_msg", "이미 존재하는 전화번호입니다");
			request.getRequestDispatcher("./join_form.jsp").forward(request,response);
			return ;
		}
		if(email.equals("why8575@naver.com")){
			request.setAttribute("email_msg", "이미 존재하는 이메일입니다");
			request.getRequestDispatcher("./join_form.jsp").forward(request,response);
			return ;
		}
		
		//02 사용자 정보 저장
		session.setAttribute("isAuth",true);
		session.setAttribute("role","ROLE_USER");
		
		//03 회원가입 처리 후 로그인 페이지 이동
		out.println("<script> alert('회원가입을 완료했습니다. 로그인 페이지로 이동합니다');location.href='login.jsp'</script>");
		
		
    
    %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    