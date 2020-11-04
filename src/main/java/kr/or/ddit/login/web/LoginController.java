package kr.or.ddit.login.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

//@WebServlet혹은 web.xml url-mapping을 통해 url등록

@SessionAttributes("rangers")
@RequestMapping("/login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//localhost/login/view 요청시 처리되는 메소드
	//요청 메소드가 GET일때만 처리 @GetMapping
	@RequestMapping(path = "/view", method = {RequestMethod.GET})
//	@GetMapping
	public String getView() {
		logger.debug("LoginController.getView()");
		return "login/view";
	}
	
	@Resource(name="MemberService")
	private MemberServiceI memberService;
	
	
	@ModelAttribute("rangers")
	public List<String> ranger(){
		logger.debug("ranger()");
		List<String> rangers=new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		return rangers;
	}
	
	
	//파라미터 이름과 동일한 이름의 메소드 인자를 선언하면
	//스프링 프레임워크가 자동으로 바인딩 해준다.
	//값을 담을 수 있는 객체를 메소드 인자로 선언한 경우에도 필드명과 파라미터 명이 동일하면 자동으로 바인딩 처리를 해준다.
	//이 때, 값을 담는 객체를 스프링 프레임워크에서는 command 객체라고 명명한다. (form전송시 담을수있는 객체)
	
	//Model : view 객체에서 응답을 생성할 때 참조할 데이터를 담는 객체
	//jsp/servlet 기반의 request 역할을 담당
	@RequestMapping(path = "/process", params = {"userid"})
	public String process(String userid, String pass, MemberVo memberVo, HttpSession session, Model model, 
						@RequestParam(name="email", required=false, defaultValue="brown@line.kr") String user_id) {
		logger.debug("LoginController.process() {} / {} / {}", userid, pass, memberVo);
		logger.debug("user_id : {} ", user_id);
		
	
//		MemberServiceI memberService = new MemberService();
		MemberVo mem = memberService.getMember(userid);
		logger.debug("mem:{}",mem);
		
		//db에서 조회한 사용자 정보가 존재하면 ==> main.jsp로 이동
		//db에서 조회한 사용자 정보가 존재하지 않으면 ==> login.jsp로 이동
	
		if (mem != null && memberVo.getPass().equals(mem.getPass())) {
			//prefix 설정이 : /WEB-INF/views/
			//surfix 설정이 : .jsp 
			//로 되어있어 그 위치를 찾을수있게
			session.setAttribute("S_MEMBER", mem);
			
			//jsp/servlet 기반에서 사용한 request.setAttribute("to_day",new Date()); 코드와 동일
			model.addAttribute("to_day", new Date());
			return "main";
		} else {
			model.addAttribute("msg","fail");
			return "login/view";

		}
		
	}
	
	//localhost/login/unt/dd
	@RequestMapping("/unt/{unt_cd}")
	public String untMain(@PathVariable("unt_cd") String unt_cd) {
		logger.debug("unt_cd:{}", unt_cd);
		return "main";
	}
	
	//localhost/login/mavView
	@RequestMapping("/mavView")
	public ModelAndView mavView(@ModelAttribute("rangers") List<String> rangers,
								@ModelAttribute("test") MemberVo memberVo) {
		ModelAndView mav = new ModelAndView();
		
		logger.debug("mavView rangers:{}", rangers);
		
		//view name 설정
		mav.setViewName("main");
		                                                                                                                                                                                                                                                                                                                                                                                                                                        
		mav.getModel().put("msg", "success");
		mav.getModelMap().addAttribute("msg","fail");
		
		return mav;
	}
	

}
