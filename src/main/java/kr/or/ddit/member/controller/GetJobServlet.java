package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.JobVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.JobService;
import kr.or.ddit.member.service.JobServiceI;


/**
 * Servlet implementation class GetJobServlet
 */
@WebServlet("/getJobServlet")
public class GetJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobServiceI service = new JobService();
		
		List<JobVo> joblist = service.getAlljob();
		
		request.setAttribute("joblist",joblist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/jops.jsp");
		rd.forward(request, response);
	}



}
