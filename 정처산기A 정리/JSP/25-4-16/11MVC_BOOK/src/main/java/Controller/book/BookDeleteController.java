package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookDeleteController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BookServiceImpl bookService;
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookDeleteController execute..");
		
		try {
			String bookCode = req.getParameter("bookCode");
			String pageno = req.getParameter("pageno")!=null?req.getParameter("pageno"):null;
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}
		
	}
	private boolean isValid(BookDto bookDto) {

		return true;
	}
	private void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
		
	}

}
