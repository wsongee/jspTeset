package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profileImg")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
       
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response content-type 설정(이미지파일이라는 것을 알려주기위해)
		response.setContentType("image/png"); //addHeader 메소드를 사용해도 된다. "image"로만 사용해도된다.
		
		//사용자 아이디 파라미터 확인하고
		String userid= request.getParameter("userid");
		
		//db에서 사용자 filename 확인
		MemberVo memberVo= memberService.getMember(userid);
		
		//경로확인 후 파일 입출력을 통해 응답생성
		//파일을 읽고 응답생성

		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos =  response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush(); 
		sos.close();
		
	}

	

}
