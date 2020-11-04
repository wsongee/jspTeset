package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

@Service("MemberService")
public class MemberService implements MemberServiceI {
	
//	@Resource(name = "MemberDao")
	private MemberDaoI memberDao;

	public MemberService() {
		memberDao = new  MemberDao();
	}

	@Override
	public MemberVo getMember(String userId) {
		return memberDao.getMember(userId);
	}

//	@Override
//	public List<MemberVo> getAllMember() {
//		return memberDao.getAllMember();
//	}
//
//	@Override
//	public Map<String, Object> selectMemberPageList(PageVo pageVo) {
//		SqlSession sqlSession = MybatisUtil.getsqlSession();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("memberList", memberDao.selectMemberPageList(sqlSession,pageVo));
//		
//		//15건, 페이지 사이즈를 7로 가정했을 때 3개의 페이지가 나와야함
//		
//		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
//		int pages = (int)Math.ceil((double)15/7);
//		map.put("pages", pages);
//		
//		sqlSession.close();
//		return map;
//	}
//
//	@Override
//	public int insertMember(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//		return memberDao.insertMember(memberVo);
//	}
//
//	@Override
//	public int updateMember(MemberVo memberVo) {
//		// TODO Auto-generated method stub
//		return memberDao.updateMember(memberVo);
//	}
//
//	@Override
//	public int deleteMember(String userid) {
//		// TODO Auto-generated method stub
//		return memberDao.deleteMember(userid);
//	}


}
