package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/login.do")
public class LoginRedirectFilter  implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("[FILTER] REDIRECT FILTER START");
		chain.doFilter(req,resp);
		System.out.println("[FILTER] REDIRECT FILTER END");
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String method = request.getMethod();
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");
		if(method.contains("POST") && (role!=null))
		{
			System.out.println("[FILTER] 로그인된 상태 확인! role : "+ role);
			switch(role)
			{
			case "ROLE_USER":
				response.sendRedirect(request.getContextPath()+"/user_main");
				return ;
			case "ROLE_MANAGER":
				response.sendRedirect(request.getContextPath()+"/manager_main");
				return ;
			case "ROLE_ADMIN":
				response.sendRedirect(request.getContextPath()+"/admin_main");
				return ;
			default :
				response.sendRedirect(request.getContextPath()+"/main_do");
				return ;
			
			}
			
		}
		
		
		System.out.println("[FILTER] REDIRECT FILTER END ");
		
		
	}
	
	
	
	//로그인 성공시 redirect 경로를 role 별로 해주기
	//admin -> /admin_main 
	//manager -> /manager_main 
	//user -> /user_main 

}
