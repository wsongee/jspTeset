package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public class MemberSeviceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberSeviceTest.class);
	
	@Test
	public void getMembertest() {
		/*** Given ***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/*** When ***/
		MemberVo memberVo = memberService.getMember(userId);

		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());

//		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void memberPageListTest() {
		/***Given***/
		MemberServiceI memberService =new MemberService();
		PageVo pageVo = new PageVo(1,7);
		int page =1;
	
		/***When***/
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		List<MemberVo> memberList = (List<MemberVo>)map.get("memberList");
		
		//생성해야할 페이지 수 
		int pages =(Integer)map.get("pages");
	
		/***Then***/	
		assertEquals(7, memberList.size());
		assertEquals(3, pages);
	}
	
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		
		for(Locale locale : locales) {
//			logger.debug(locale.toString());
			logger.debug("{}",locale);
		}
	}
	
	@Test
	public void updateMemberDaoTest() {
		/***Given***/
		MemberServiceI memberService =new MemberService();
		MemberVo memberVo = new MemberVo("woo","송송","1234","aaaaaaaa","대전중구중앙로76","영밀빌딩 404호","34940","d:\\profile\\wsi.png","wsi.png");

		/***When***/
		int updateCnt = memberService.updateMember(memberVo);
		/***Then***/
		assertEquals(1, updateCnt);
		
		
	}
}
