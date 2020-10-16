package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public class MemberDaoTest {

	@Test
	public void getMembertest() {
		/***Given***/
		MemberDaoI  memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		

		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);

		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		//동일(==)
		//동치(equals)
		
//		assertEquals(answerMemberVo, memberVo);
	}

	@Test
	public void getAllMember() {
		/***Given***/
		MemberDaoI  memberDao = new MemberDao();

		/***When***/
	
		List<MemberVo> memlist= memberDao.getAllMember();
		
		/***Then***/
		assertEquals(15, memlist.size());
//		assertEquals("brown", memlist.get(0).getUserid()); // 순서가 맞지않는 올바르지않은 구문
	}
	
	public void selectMemberPageListTesT() {
		/***Given***/
		
		MemberDaoI memberDao =new MemberDao();
		PageVo pageVo = new PageVo(1,7);

		SqlSession sqlSession = MybatisUtil.getsqlSession();
		/***When***/
		List<MemberVo> memberList = memberDao.selectMemberPageList(sqlSession, pageVo);
		/***Then***/
		assertEquals(7, memberList.size());
	}
	

	@Test
	public void selectMemberTotalCntTest() {
		/***Given***/
		
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getsqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15,  totalCnt );
	}
}
