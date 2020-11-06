package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.JSRMemberVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.MemberVoValidator;
import kr.or.ddit.member.model.PageVo;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberPageListController {
	private static final Logger logger = LoggerFactory.getLogger(MemberPageListController.class);

	@RequestMapping("/view")
	public String view() {
		return "member/memberList";
	}
	
	@Resource(name="MemberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/memberPageList")
	public String memberPageList(Model model, @RequestParam(name="page",required = false, defaultValue = "1")int page,
							@RequestParam(name="pageSize", required = false, defaultValue = "5")int pageSize) {
		
//		String page_str = request.getParameter("page");
//		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		model.addAttribute("page", page);
		
		//pageSize
//		String pageSize_str= request.getParameter("pageSize");
//		int pageSize = pageSize_str == null ? 7 : Integer.parseInt(page_str);
		model.addAttribute("pageSize", pageSize);
		
		//pageVo :page,pageSize
		PageVo pageVo = new PageVo(page, pageSize);
		model.addAttribute("pageVo", pageVo);
		
		
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		
		return "member/memberList";
	}
	
	
	@RequestMapping("/memberSelect")
	public String memberSelect(Model model,@RequestParam("userid")String userid) {
		
		MemberVo memberVo = memberService.getMember(userid);
		
		model.addAttribute("memberVo", memberVo);
		
	
		return "member/member";
	}
	
	@RequestMapping("/profileImg")
	public void profileImg(@RequestParam("userid")String userid, HttpServletResponse response) throws FileNotFoundException, IOException {
		
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
		
//		return "member/member";
	}
	
	
	@RequestMapping("/memberRegistView")
	public String memberResistView() {
		return "member/memberRegist";
	}
	
	@RequestMapping("/memberRegist")
	public String memberRegist(@Valid MemberVo memberVo, BindingResult br, @RequestParam("file")MultipartFile file) {
//		public String memberRegist(@Valid JSRMemberVo memberVo, BindingResult br, @RequestParam("file")MultipartFile file) {
		
//		new MemberVoValidator().validate(memberVo, br);
		
		//검증을 통과하지 못했으므로 사용자 등록화면으로 이동
		if(br.hasErrors()) {
			return "member/memberRegist";
		}
		
		
		logger.debug("memberVo : {},{},{},{},{},{},{}",memberVo);

//		Part profile = model.getPart("realFilename");
//		logger.debug("file:{}", profile.getHeader("Content-Disposition"));
		
//		String realFilename= FileUploadUtil.getFileName(profile.getHeader("Content-Disposition"));
		String fileName= UUID.randomUUID().toString();
		
//		String extension = FileUploadUtil.getExtenstion(file.getOriginalFilename());
	
		
		File uploadFile = new File("d:\\upload\\"+file.getOriginalFilename());
		if(file.getSize()>0) {
//			filePath = "d:\\profile\\"+ fileName + "." + extension;
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//사용자정보등록
		memberVo.setRealFilename(file.getOriginalFilename());
		memberVo.setFilename("d:\\upload\\"+file.getOriginalFilename());
		
		
//		//사용자정보등록
//		MemberVo memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, file);
		
		int insertCnt = memberService.insertMember(memberVo);
		
		// 1건이 입력되었을때 :정상 ->memberList 페이지로 이동
		// 1건이 아닐때: 비정상
		if (insertCnt == 1) {
			// 서버의 상태가 바뀔때는 중복이 되지 않게 redirect요청을 해준다.
			// redirect한다는것은 메소드 인자를 웹 브라우저 주소창에 넣으라는 것이기 떄문에 정상동작이 안될수 있으므로 contextpath넣어주기
			return "redirect:/member/memberPageList";
		} else {
			return "member/memberRegist";
		}
	}
	
	
	@RequestMapping("/memberUpdateView")
	public String memberUpdateView(Model model, @RequestParam("userid")String userid) {
		
		MemberVo memberVo = memberService.getMember(userid);
		memberVo.setUserid(userid);
		model.addAttribute("memberVo", memberVo);
		
		return "member/memberUpdate";
	}
	
	@RequestMapping("/memberupdate2")
	public String memberupdate2(MemberVo memberVo, @RequestParam("file")MultipartFile file,
			@RequestParam("userid")String userid) {
		
		
		logger.debug("memberVo : {},{},{},{},{},{},{}",memberVo);
		
		if(file.getSize()>0) {
			try {
				File uploadFile = new File("d:\\upload\\"+file.getOriginalFilename());
				file.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			memberVo.setRealFilename(file.getOriginalFilename());
			memberVo.setFilename("d:\\upload\\"+file.getOriginalFilename());
			
		}else {
			MemberVo dbmemVo =memberService.getMember(userid);
			memberVo.setRealFilename(dbmemVo.getRealFilename());
			memberVo.setFilename(dbmemVo.getFilename());
		}
		

//		if(memberVo.getRealFilename()==null) {
//			memberVo = memberService.getMember(userid);
//		
//		}
		
//		//사용자정보등록
//		MemberVo memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, file);
		
		int updateCnt = memberService.updateMember(memberVo);
		logger.debug("updateCnt !@!@!@!@: {}",updateCnt);
		logger.debug("memberVo222 : {},{},{},{},{},{},{}",memberVo);
		
		// 1건이 입력되었을때 :정상 ->memberList 페이지로 이동
		// 1건이 아닐때: 비정상

			// 서버의 상태가 바뀔때는 중복이 되지 않게 redirect요청을 해준다.
			// redirect한다는것은 메소드 인자를 웹 브라우저 주소창에 넣으라는 것이기 떄문에 정상동작이 안될수 있으므로 contextpath넣어주기
		return "redirect:/member/memberPageList";

	}

} 
