package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVo;

public class MemberTestService extends ModelTestConfig {

	@Resource(name="MemberService")
	private MemberServiceI memberService;
	
	@Test
	public void insertMember_SUCCESS_TEST() {
		/***Given***/
		MemberVo memberVo = new MemberVo("ddit","dditpass","대적인재","개박원","","","","","");

		/***When***/
		int insertCnt=memberService.insertMember(memberVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}

	
//	@Test
	public void insertMember_FAIL_TEST() {
		/***Given***/
		MemberVo memberVo = new MemberVo("ddit","dditpass","대적인재","개박원","","","","","");

		/***When***/
		int insertCnt=memberService.insertMember(memberVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}

}
