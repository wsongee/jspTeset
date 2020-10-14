package kr.or.ddit.el;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	private static final Logger logger = LoggerFactory.getLogger(ElServlet.class);
	
	@Override
		public void init() throws ServletException {
			memberService = new MemberService();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scope= request.getParameter("scope");
		logger.debug("scope : {} ",scope);
		
		if(scope.equals("requestValue")) {
			request.setAttribute("attr", scope);
		}
		else if(scope.equals("sessionValue")) {
			request.setAttribute("attr", scope);
			request.getSession().setAttribute("attr", scope);
		}
		else if(scope.equals("applicationValue")) {
			request.setAttribute("attr", scope);
			request.getSession().setAttribute("attr", scope);
			getServletContext().setAttribute("attr", scope);
		}
		
		//Map객체를 생성하여 request속성에 넣어준다.
		Map<String, String> map= new HashMap<String, String>();
		map.put("brown", "브라운");
		map.put("sally", "샐리");
		request.setAttribute("rangers", map);
		
		//list객체를 request솔성에 넣어준다
		request.setAttribute("rangersList", memberService.getAllMember());
		
		
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
	}
}
