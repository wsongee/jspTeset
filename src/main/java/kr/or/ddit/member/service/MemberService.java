package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

public class MemberService implements MemberServiceI {
//	private MemberDaoI memdao;
//	
//	private static MemberService service;
//	
//	public MemberService() {
//		memdao = new  MemberDao();
//	}
//	
//	public static MemberService getInstance() {
//		if(service==null) {
//			service= new MemberService();
//		}
//		return service;
//	}
	
	@Override
	public MemberVo getMember(String userId) {
		MemberDaoI memberDao = new MemberDao();
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVo> getAllMember() {
		MemberDaoI memberDao =new MemberDao();
		return memberDao.getAllMember();
	}


}
