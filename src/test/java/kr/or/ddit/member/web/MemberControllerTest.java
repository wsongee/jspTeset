package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.WebTestConfig;

public class MemberControllerTest extends WebTestConfig {

	@Test
	public void viewTest() throws Exception {
		mockMvc.perform(get("/member/view"))
				.andExpect(status().isOk())
				.andExpect(view().name("member/memberList"));

	}
	
	@Test
	public void memberPageListTest() throws Exception {
		mockMvc.perform(get("/member/memberPageList")
				.param("page","1")
				.param("pageSize", "5"))
				.andExpect(status().is(200))
				.andExpect(view().name("member/memberList"))
				.andExpect(model().attributeExists("page"))
				.andExpect(model().attributeExists("pageSize"))
				.andExpect(model().attributeExists("pageVo"))
				.andExpect(model().attributeExists("memberList"))
				.andExpect(model().attributeExists("pages"));
	}
	
	@Test
	public void memberSelectTest() throws Exception {
		mockMvc.perform(get("/member/memberSelect")
				.param("userid", "brown"))
				.andExpect(status().is(200))
				.andExpect(view().name("member/member"))
				.andExpect(model().attributeExists("memberVo"));
	}
	
	@Test
	public void profileImg() throws Exception {
		mockMvc.perform(get("/member/profileImg")
				.param("userid", "brown"))
				.andExpect(status().is(200));
				
	}
	
	@Test
	public void memberRegistViewTest() throws Exception {
		mockMvc.perform(get("/member/memberRegistView"))
				.andExpect(status().isOk())
				.andExpect(view().name("member/memberRegist"));
		
	}
	
	@Test
	public void memberRegistTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		
		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png",is);
		
		mockMvc.perform(fileUpload("/member/memberRegist")
				.file(file)
				.param("userid", "swwww")
				.param("pass", "1234")
				.param("usernm", "우송이")
				.param("alias", "송이버섯")
				.param("reg_dt", "2020/11/05")
				.param("addr1", "대전광역시 중구 대흥동")
				.param("addr2", "영민빌딩쓰")
				.param("zipcode", "11111"))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/member/memberPageList"));
				
	}
	
	@Test
	public void memberUpdateViewTest() throws Exception {
		mockMvc.perform(get("/member/memberUpdateView")
				.param("userid", "brown"))
		.andExpect(status().is(200))
		.andExpect(view().name("member/memberUpdate"));
	}
	
	
	@Test
	public void memberupdateTest() throws Exception {
		
	InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		
		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png",is);
		
		mockMvc.perform(fileUpload("/member/memberupdate2")
				.file(file)
				.param("userid", "swwww")
				.param("pass", "1234")
				.param("usernm", "박다미바보")
				.param("alias", "송이버섯")
				.param("reg_dt", "2020/11/05")
				.param("addr1", "대전광역시 중구 대흥동")
				.param("addr2", "영민빌딩쓰")
				.param("zipcode", "11111"))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/member/memberPageList"));		
	}

}
