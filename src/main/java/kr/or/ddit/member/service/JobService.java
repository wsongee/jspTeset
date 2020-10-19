package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.JobDao;
import kr.or.ddit.member.dao.JobDaoI;
import kr.or.ddit.member.model.JobVo;

public class JobService implements JobServiceI{
	
	private JobDaoI jobdao;
	
	private static JobService service;
	
	public JobService() {
		jobdao = new JobDao();
	}
	 

	@Override
	public List<JobVo> getAlljob() {
		JobDaoI jobdao = new JobDao();
		return jobdao.getAlljob();
	}

}
