package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public class MemberSeviceTest {
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
}
