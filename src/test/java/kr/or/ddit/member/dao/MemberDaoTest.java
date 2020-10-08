package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	@Test
	public void getMembertest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserId("brown");
		answerMemberVo.setPassword("passBrown");
		

		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);

		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		//동일(==)
		//동치(equals)
		
		assertEquals(answerMemberVo, memberVo);
	}

}
