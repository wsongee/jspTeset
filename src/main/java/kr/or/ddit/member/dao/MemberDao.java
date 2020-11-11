package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

@Repository("MemberRepository")
public class MemberDao implements MemberDaoI {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVo getMember(String userId) {
		//원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		//우리는 controller기능에 집중 -> 하드코딩을 통해 dao, service는 간략하게 넘어간다
		//Mock(가짜)
		
//		MemberVo memberVo = new MemberVo();
//		memberVo.setUserId("brown");
//		memberVo.setPassword("passBrown");
		
//		SqlSession sqlSession =MybatisUtil.getsqlSession();
		
		
		//select
		//한건 : selectOne
		//여러건: selectList
		
//		MemberVo memberVo = sqlSession.selectOne("member.getMember", userId);
//		sqlSession.close();
		
		return sqlSession.selectOne("member.getMember", userId);
	}

	@Override
	public List<MemberVo> getAllMember() {

//		SqlSession sqlSession = MybatisUtil.getsqlSession();
		List<MemberVo> memlist = sqlSession.selectList("member.getAllMember");
		
//		sqlSession.commit();
//		sqlSession.rollback();
		
		return memlist;
	}

	@Override
	public List<MemberVo> selectMemberPageList(PageVo pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
		
	}

	@Override
	public int selectMemberTotalCnt() {
		 return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVo memberVo) {
//		SqlSession sqlSession = MybatisUtil.getsqlSession();
//		int insertCnt = 0;
//		try {
//			insertCnt = sqlSession.insert("member.insertMember", memberVo);
//		} catch (Exception e) {
//
//		}
//
//		if (insertCnt == 1) {
////			sqlSession.commit();
//		} else {
////			sqlSession.rollback();
//		}
////		sqlSession.close();

		return sqlSession.insert("member.insertMember", memberVo);
	}
//
//	@Override
//	public int deleteMember(String userid) {
//		SqlSession sqlSession = MybatisUtil.getsqlSession();
//
//		int deleteCnt = sqlSession.delete("member.deleteMember",userid);
//		
//		if(deleteCnt ==1 ) {
//			sqlSession.commit();
//		}else {
//			sqlSession.rollback();
//		}
//		sqlSession.close();
//		
//		return deleteCnt;
//	}
//
	@Override
	public int updateMember(MemberVo memberVo) {


		return sqlSession.update("member.updateMember",memberVo);
	}
	

	
	

}
