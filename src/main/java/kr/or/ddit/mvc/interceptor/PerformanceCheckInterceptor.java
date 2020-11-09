package kr.or.ddit.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PerformanceCheckInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(PerformanceCheckInterceptor.class);
	
	private long start;
	private long end;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		start = System.currentTimeMillis(); //1ms==1/1000몇초?
		
		request.setAttribute("start", start);
		
//		System.nanoTime(); ///1ns = 1/1000000000
		//true : 다음 인터셉터 호출, 인터셉터가 없을 경우 handler(cotroller)
		//false : 요청 처리를 멈춘다.
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		
		long start = (long)request.getAttribute("start");
		
		end = System.currentTimeMillis();
		logger.debug("{} end-start :{} ",handler,(end-start));
	}
	
}
