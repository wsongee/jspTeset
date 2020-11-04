package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVo;

public interface MemberDaoI {

	MemberVo getMember(String userId);
	
//	List<MemberVo> getAllMember();
//
//	List<MemberVo> selectMemberPageList(SqlSession sqlsession, PageVo pageVo);
//	
//	int selectMemberTotalCnt(SqlSession sqlsession);
//	
//	int insertMember(MemberVo memberVo);
//	
//	int deleteMember(String userid);
//	
//	int updateMember(MemberVo memberVo);
}
