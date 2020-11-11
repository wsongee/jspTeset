package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.model.PageVo;

@Service("MemberService")
public class MemberService implements MemberServiceI {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Resource(name = "MemberRepository")
	private MemberDaoI memberDao;

	public MemberService() {
//		memberDao = new  MemberDao();
	}

	@Override
	public MemberVo getMember(String userId) {
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVo> getAllMember() {
		return memberDao.getAllMember();
	}
//
	@Override
	public Map<String, Object> selectMemberPageList(PageVo pageVo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectMemberPageList(pageVo));
		
		//15건, 페이지 사이즈를 7로 가정했을 때 3개의 페이지가 나와야함
		
		int totalCnt = memberDao.selectMemberTotalCnt();
		int pages = (int)Math.ceil((double)15/7);
		map.put("pages", pages);
		
		return map;
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		
//		logger.debug("첫번째 insert시작전");
//		memberDao.insertMember(memberVo);
//		logger.debug("첫번째 insert종료후");
		
//		첫번째 쿼리는 정상적으로 실행되지만
//		두번째 쿼리에서 동일한 데이터를 입력하여 primary key 제약조건에 의해
//		sql 실행실패
//		첫번째 쿼리는 성공했지만 트랜잭션 설정을 service 레벨에 설정을 하였기 때문에
//		서비스 메소드에서 실행된 모든 쿼리를 rollback 처리한다.
		
//		logger.debug("두번째 insert시작전");
//		memberDao.insertMember(memberVo);
//		logger.debug("두번째 insert종료후");
//		return 1;
		return memberDao.insertMember(memberVo);
	}


//	@Override
//	public int selectMemberTotalCnt() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int updateMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.updateMember(memberVo);
	}
//
//	@Override
//	public int deleteMember(String userid) {
//		// TODO Auto-generated method stub
//		return memberDao.deleteMember(userid);
//	}


}
