package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;

public class MemberSeviceTest {
	@Test
	public void getMembertest() {
		/*** Given ***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserId("brown");
		answerMemberVo.setPassword("passBrown");

		/*** When ***/
		MemberVo memberVo = memberService.getMember(userId);

		/*** Then ***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());

		assertEquals(answerMemberVo, memberVo);
	}
}
