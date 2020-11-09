package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/profile")
@Controller
public class ProfileController {
	
	@Resource(name="MemberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/profileImg")
	public void profileImg(HttpServletResponse response, String userid) throws IOException {
		response.setContentType("image/png");
		
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
