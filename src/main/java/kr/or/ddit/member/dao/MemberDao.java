package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public class MemberDao implements MemberDaoI {

	@Override
	public MemberVo getMember(String userId) {
		//원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		//우리는 controller기능에 집중 -> 하드코딩을 통해 dao, service는 간략하게 넘어간다
		//Mock(가짜)
		
//		MemberVo memberVo = new MemberVo();
//		memberVo.setUserId("brown");
//		memberVo.setPassword("passBrown");
		
		SqlSession sqlSession =MybatisUtil.getsqlSession();
		
		
		//select
		//한건 : selectOne
		//여러건: selectList
		
		MemberVo memberVo = sqlSession.selectOne("member.getMember", userId);
		sqlSession.close();
		
		return memberVo;
	}

	@Override
	public List<MemberVo> getAllMember() {

		SqlSession sqlSession = MybatisUtil.getsqlSession();
		List<MemberVo> memlist = sqlSession.selectList("member.getAllMember");
		
		sqlSession.commit();
//		sqlSession.rollback();
		
		return memlist;
	}

	@Override
	public List<MemberVo> selectMemberPageList(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
		
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		 return sqlSession.selectOne("member.selectMemberTotalCnt");
	}
	
	

}
