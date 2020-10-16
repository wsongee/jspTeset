package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public interface MemberDaoI {

	MemberVo getMember(String userId);
	
	List<MemberVo> getAllMember();

	List<MemberVo> selectMemberPageList(SqlSession sqlsession, PageVo pageVo);
	
	int selectMemberTotalCnt(SqlSession sqlsession);
}
