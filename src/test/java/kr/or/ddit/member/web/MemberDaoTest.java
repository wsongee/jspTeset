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

}
