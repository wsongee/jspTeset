package kr.or.ddit.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.delegate.RedirectServlet;

/**
 * Servlet implementation class SumCalculationServlet
 */
@WebServlet("/sumCalculationServlet")
public class SumCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(SumCalculationServlet.class);

	//입력화면 요청처리(sumInput.jsp)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumGet.jsp");
		rd.forward(request, response);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("sumCalculationServlet.doPost()");
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));

		int sumResult = 0;
		
		for(int i = start ; i<=end ; i++) {
			sumResult += i;
		}
		
		logger.debug("sumResult:{} ", sumResult);

//		List<String> calculation = new ArrayList<>();	
//		calculation.add("start");
//		calculation.add("end");
		
//		request.setAttribute("sumResult", sumResult);

		HttpSession session =request.getSession();
		session.setAttribute("sumResult", sumResult);
	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumResult.jsp");
		rd.forward(request, response);
	
	}

}
