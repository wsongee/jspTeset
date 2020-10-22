package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public class MemberDaoTest {
	
	/*
	테스트 메소드 Life cycle : 
	@BeforeClass(static)
	 @Before => @Test => @After
	
	@AfterClass(static)
	
	*/
	
	MemberDaoI memberDao;

	@Before
	public void setup() {
		/***Given***/
		memberDao = new MemberDao();
		String userid = "12345";
		memberDao.deleteMember(userid);
		/***When***/

		/***Then***/
	}
	

	@Test
	public void getMembertest() {
		/***Given***/
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

		/***When***/
	
		List<MemberVo> memlist= memberDao.getAllMember();
		
		/***Then***/
		assertEquals(15, memlist.size());
//		assertEquals("brown", memlist.get(0).getUserid()); // 순서가 맞지않는 올바르지않은 구문
	}
	
	@Test
	public void selectMemberPageListTesT() {
		/***Given***/
		
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
		
		SqlSession sqlSession = MybatisUtil.getsqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15,  totalCnt );
	}
	
	@Test
	public void insertMemberDaoTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("12345","우송이","1234","ag","대전중구중앙로76","영밀빌딩 404호","34940","d:\\profile\\wsi.png","wsi.png");
		
		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateMemberDaoTest() {
		/***Given***/
		MemberVo memberVo= new MemberVo("woo","송송","1234","aaaaaaaa","대전중구중앙로76","영밀빌딩 404호","34940","d:\\profile\\wsi.png","wsi.png");

		/***When***/
		int updateCnt = memberDao.updateMember(memberVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
}
