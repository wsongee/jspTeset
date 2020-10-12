package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	@Test
	public void getMembertest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		

		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);

		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		//동일(==)
		//동치(equals)
		
		assertEquals(answerMemberVo, memberVo);
	}

	@Test
	public void getAllMember() {
		/***Given***/
		MemberDao memberDao = new MemberDao();

		/***When***/
	
		List<MemberVo> memlist= memberDao.getAllMember();
		
		/***Then***/
		assertEquals(5, memlist.size());
//		assertEquals("brown", memlist.get(0).getUserid()); // 순서가 맞지않는 올바르지않은 구문
	}
}
