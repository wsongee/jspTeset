package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.JobVo;

public class JobDao implements JobDaoI {

	@Override
	public List<JobVo> getAlljob() {
		
		SqlSession sqlSession =MybatisUtil.getsqlSession();
		
		List<JobVo> joblist = sqlSession.selectList("job.getAllJob");
		
		return joblist;
	}

}
