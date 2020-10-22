package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;



@WebServlet("/memberRegist")
@MultipartConfig
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
	MemberServiceI memberService;
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias= request.getParameter("alias");
		String pass =request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode =request.getParameter("zipcode");
		
		logger.debug("parameter : {},{},{},{},{},{},{}",userid, usernm, alias, pass, addr1, addr2, zipcode);

		Part profile = request.getPart("realFilename");
		logger.debug("file:{}", profile.getHeader("Content-Disposition"));
		
		
		String realFilename= FileUploadUtil.getFileName(profile.getHeader("Content-Disposition"));
		String fileName= UUID.randomUUID().toString();
		
		String extension = FileUploadUtil.getExtenstion(realFilename);
		String filePath="";
		
		if(profile.getSize()>0) {
			filePath = "d:\\profile\\"+ fileName + "." + extension;
			profile.write(filePath);
		}
		
		//사용자정보등록
		MemberVo memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFilename);
		
		int insertCnt = memberService.insertMember(memberVo);
		
		//1건이 입력되었을때 :정상 ->memberList 페이지로 이동
		//1건이 아닐때: 비정상
		if(insertCnt == 1) {
			//서버의 상태가 바뀔때는 중복이 되지 않게 redirect요청을 해준다.
			//redirect한다는것은 메소드 인자를 웹 브라우저 주소창에 넣으라는 것이기 떄문에 정상동작이 안될수 있으므로 contextpath넣어주기
			response.sendRedirect(request.getContextPath()+"/memberPageListServlet");
		}else {
			doGet(request, response); // 다시화면 요청이므로 doget메서드 불러오기
		}
 		
	
	}

}
