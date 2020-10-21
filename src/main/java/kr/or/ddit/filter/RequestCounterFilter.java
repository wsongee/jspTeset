package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebFilter("/*")
public class RequestCounterFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	Map<String, Integer> requestCounterMap;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("RequestCounterFilter.init()");
		requestCounterMap = new HashMap<String, Integer>();
		//request, session, application
		
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("requestCounterMap", requestCounterMap);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("RequestCounterFilter.doFilter()");
		
		HttpServletRequest req = (HttpServletRequest)request;
		logger.debug("uri : {} ",req.getRequestURI());
		
		//uri별 요청 횟수
		//만약 /memberList 12번 요청
		//    /jstl/jstl_fmt_date.jsp 20번 요청이 왔다면
		//어떤 자료구조를 쓰면 좋을까?
		//List, Set, Map
		
		//map객체에서 uri에 해당하는 요청이 있었는지 확인
		//없으면 값을 1로 해서 새로운 key로 추가
		//있으면 기존값에서 1을 더해 값을 수정
		
		Integer value =requestCounterMap.get(req.getRequestURI());
		//해당 uri로 최초요청
		if(value==null) {
			requestCounterMap.put(req.getRequestURI(),1);
		}
		//해당 uri 로 최소 한번이상 요청이 존재 했던 경우
		else {
			requestCounterMap.put(req.getRequestURI(), value+1);
		}
		
		
		//등록된 다른 필터로 요청을 위임
		//만약, 더이상 등록된 Filter가 없을 경우 요청을 처리할 서블릿 / jsp로 요청을 전달
		
		//전처리
		logger.debug("RequestCounterFilter 전처리 부분 - chain.doFilter 호출전");
		chain.doFilter(request, response);
		//후처리 -> servlet에서 응답생성후 응답이 웹브라우저로 가는 단계에서 후속처리
		logger.debug("RequestCounterFilter 후처리 부분 - chain.doFilter 호출후");
	
	}

	@Override
	public void destroy() {
		
	}
	
}
