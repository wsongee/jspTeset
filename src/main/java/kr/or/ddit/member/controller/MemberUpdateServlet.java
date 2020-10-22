package kr.or.ddit.member.controller;

import java.io.IOException;
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

@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
	MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		
		MemberVo memberVo = memberService.getMember(userid);
		memberVo.setUserid(userid);
		request.setAttribute("memberVo", memberVo);
		logger.debug("memberVo: {} "+memberVo);
		
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
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
//		String filename =request.getParameter("filename");
//		String realFilename =request.getParameter("realFilename");
		
		logger.debug("parameter : {},{},{},{},{},{},{}",userid, usernm, alias, pass, addr1, addr2, zipcode);
			
			Part profile = request.getPart("realFilename");
			logger.debug("file:{}", profile.getHeader("Content-Disposition"));
			
			String realFilename= FileUploadUtil.getFileName(profile.getHeader("Content-Disposition"));
			String filePath="";
			
			if(realFilename==null ||realFilename.equals("")) {
				//원래있던 파일을 불러와서 지정해주고
				MemberVo memberVo = memberService.getMember(userid);
				filePath = memberVo.getFilename();
				realFilename = memberVo.getRealFilename();
			}

			String filename= UUID.randomUUID().toString(); //filename 이 똑같은게 있으면 얘네가 알아서 처리해줌
			String extension = FileUploadUtil.getExtenstion(realFilename);
			
			if(profile.getSize()>0) {
				filePath = "d:\\profile\\"+ filename + "." + extension;
				profile.write(filePath);
				logger.debug("filePath:"+filePath);
			}
		
		
		//수정시 사진수정안했는데 filename이 null일때
		//기존의 파일을 넣어준다.
		//사용자정보수정
		MemberVo memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFilename);
		
		int updateCnt = memberService.updateMember(memberVo);
		
		//1건이 입력되었을때 :정상 ->memberList 페이지로 이동
		//1건이 아닐때: 비정상
		if(updateCnt == 1) {
			//서버의 상태가 바뀔때는 중복이 되지 않게 redirect요청을 해준다.
			//redirect한다는것은 메소드 인자를 웹 브라우저 주소창에 넣으라는 것이기 떄문에 정상동작이 안될수 있으므로 contextpath넣어주기
			response.sendRedirect(request.getContextPath()+"/memberPageListServlet");
		}else {
			doGet(request, response); // 다시화면 요청이므로 doget메서드 불러오기
		}
 		
	
	}	
		

}
