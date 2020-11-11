package kr.or.ddit.member.web;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;


public class MemberDaoTest extends ModelTestConfig{

	@Resource(name = "MemberRepository")
	private MemberDaoI memberDao;
	
	@Test
	public void test() {
		/***Given***/
		
		/***When***/
		List<MemberVo> memberlist=memberDao.getAllMember();
		
		/***Then***/
		assertTrue(memberlist.size()>13);
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userId="brown";
		
		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
	}

	@Test
	public void selectMemberPageListTeset() {
		/***Given***/
		PageVo pageVo = new PageVo(1,7);

		/***When***/
		List<MemberVo> memberList = memberDao.selectMemberPageList(pageVo);

		/***Then***/
		assertEquals(7, memberList.size());
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/***Given***/
		

		/***When***/
		int totalCnt= memberDao.selectMemberTotalCnt();

		/***Then***/
		assertEquals(20, totalCnt);
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("ddit11","dditpass","대적인재","개박원","","","","","");

		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("swwww","박다미메롱","1234","송이버섯","대전광역시 중구 대흥동","영민빌딩쓰","11111","d:\\upload\\sally.png","sally.png");

		/***When***/
		int updqteCnt = memberDao.updateMember(memberVo);

		/***Then***/
		assertEquals(1, updqteCnt);
	}
}
