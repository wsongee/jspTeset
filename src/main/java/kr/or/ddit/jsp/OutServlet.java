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

import kr.or.ddit.ranger.service.RangerService;
import kr.or.ddit.ranger.service.RangerServiceI;

/**
 * Servlet implementation class OutServlet
 */
@WebServlet("/outServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ranger 정보 조회
		RangerServiceI rangerService = new RangerService();
		
		//ranger 정보를 화면에 표현해줄 out.jsp 파일로 응답 생성을 위임
		//ranger 정보가 어딘가 담겨야함
		//servlet에서는 3가지 scope가 사용가능
		//request < session < application
		//해당 요청은 일회성으로만 처리해주면 레인저 이름 정보를 보관할 필요가 없고
		//다른 요청과 관련이 없으므로 request 가 적당하다.
		
		//servlet상에서 작성할 코드
		//request 객체에 rangers라는 속성이름으로 레인저정보를 저장
		List<String> rangers = rangerService.getRangers();
		
//		rangers = rangerService.getRangers();
		request.setAttribute("rangers", rangers);

		//out.jsp(아직 안만듬 webapp/jsp/out.jsp에 생성)로 요청(forward)
		//***out 객체를 이용
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/out.jsp");
		rd.forward(request, response);
		
		
	}

}
