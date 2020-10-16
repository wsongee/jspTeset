package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberPageListServlet
 */
@WebServlet("/memberPageListServlet")
public class MemberPageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	
	
	@Override
		public void init() throws ServletException {
			memberService =  new MemberService();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int cpage = Integer.parseInt(request.getParameter("page"));
//		
//		
//		MemberServiceI service = new MemberService();
//				
//		int totalPage = 7;
//		int start=cpage
//		int end;
//		
//		Map<String, Integer> map = service.selectMemberPageList();
//		
//		map.put("start", start);
//		map.put("end",end);
		
		
		//1. page 파라미터를 받는다
		//2. page 파라미터가 없을경우를 1이라고 가정
		//3. memberService.selectMemberPageList에 파라미터를 추가하여 페이징 처리가 가능하게끔 수정 or 새로운메소드 생성
		
		//memberService.selectMemberPageList(page)=> List<MemberVo> => Map<String,Objcet>
		
		//page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
		
		//pageSize
		String pageSize_str= request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 7 : Integer.parseInt(page_str);
		request.setAttribute("PageSize", pageSize);
		
		//pageVo :page,pageSize
		PageVo pageVo = new PageVo(page, pageSize);
		request.setAttribute("pageVo", pageVo);
		
		
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		request.setAttribute("memberList", map.get("memberList"));
		request.setAttribute("pages", map.get("pages"));
		
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
		
		
	
	}

	
}
