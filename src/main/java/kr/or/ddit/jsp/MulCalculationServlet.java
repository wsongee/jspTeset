package kr.or.ddit.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class MulCalculationServlet
 */
@WebServlet("/mulCalculationServlet")
public class MulCalculationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MulCalculationServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/mulGet.jsp");
		rd.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("mulCalculationServlet.doPost()");
		
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		

		int mulResult=param1*param2;
		
		
		logger.debug("mulResult : {}", mulResult);
		
		
		HttpSession session =request.getSession();
		session.setAttribute("mulResult", mulResult);
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/mulResult.jsp");
		rd.forward(request, response);
	}

}
