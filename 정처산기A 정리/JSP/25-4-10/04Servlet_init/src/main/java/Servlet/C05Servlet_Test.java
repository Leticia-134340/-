package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class C05Servlet_Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /login.do...");
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get /login.do...");
		//파라미터
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//입력값
		
		//세션과 대조
		HttpSession session = req.getSession();
		String dbUsername = (String)session.getAttribute("username");
		String dbPassword = (String)session.getAttribute("password");
		if(!username.equals(dbUsername)) {
			req.setAttribute("username_msg","ID가 일치하지 않습니다");
			
		}
		if(!password.equals(dbPassword)) {
			req.setAttribute("password_msg", "PW가 일치하지 않습니다");
		}
		if(!username.equals(dbUsername) || !password.equals(dbPassword)) {
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			return ;
		}
		//Main 이동
		resp.sendRedirect(req.getContextPath() + "/main.do");
		
		//뷰(/login.do redirect)
		resp.sendRedirect(req.getContextPath() + "/login.do");
		
		//05Servlet_test.java - login.do 처리 서블릿
		//실제 login.jsp는 /web-inf에서 생성하고 forwarding 처리
		
		
	}
	
	
		
}
