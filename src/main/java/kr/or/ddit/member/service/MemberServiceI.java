package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

public interface MemberServiceI {

	MemberVo getMember(String userId);
	
	List<MemberVo> getAllMember();

	Map<String, Object> selectMemberPageList(PageVo pageVo);
	
//	int selectMemberTotalCnt();

}
