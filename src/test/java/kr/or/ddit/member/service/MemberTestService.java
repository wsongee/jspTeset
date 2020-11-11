package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public class MemberTestService extends ModelTestConfig {

	@Resource(name="MemberService")
	private MemberServiceI memberService;
	
	@Test
	public void insertMember_SUCCESS_TEST() {
		/***Given***/
		MemberVo memberVo = new MemberVo("temp","dditpass","대적인재","개박원","","","","","");

		/***When***/
		int insertCnt=memberService.insertMember(memberVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}

	
//	@Test
//	public void insertMember_FAIL_TEST() {
//		/***Given***/
//		MemberVo memberVo = new MemberVo("ddit","dditpass","대적인재","개박원","","","","","");
//
//		/***When***/
//		int insertCnt=memberService.insertMember(memberVo);
//		/***Then***/
//		assertEquals(1, insertCnt);
//	}
//	
	
	@Test
	public void getMember_SUCCESS_TEST() {
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		MemberVo memberVo = memberService.getMember(userId);

		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());

	}
	
	@Test
	public void selectMemberPageList_SUCCESS_TEST() {
		/***Given***/
		PageVo pageVo = new PageVo(1,7);
		
		/***When***/
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		List<MemberVo> memberList = (List<MemberVo>)map.get("memberList");
		
		int pages =(Integer)map.get("pages");
		
		/***Then***/
		assertEquals(7, memberList.size());
		assertEquals(3, pages);
	}
	
	@Test
	public void updateMember_SUCCESS_TEST() {
		/***Given***/
		MemberVo memberVo = new MemberVo("swwww","박다미메롱","1234","송이버섯","대전광역시 중구 대흥동","영민빌딩쓰","11111","d:\\upload\\sally.png","sally.png");
		/***When***/
		int updateCnt = memberService.updateMember(memberVo);
		
		/***Then***/
		assertEquals(1,updateCnt);
	}

}
