package kr.or.ddit.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisUtilTest {

	@Test
	public void getSqlSessionTest() {
		/***Given***/
		

		/***When***/
		SqlSession sqlSession= MybatisUtil.getsqlSession();
		/***Then***/
		assertNotNull(sqlSession);
	}

}
