package kr.or.ddit.config.spring;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor;
import kr.or.ddit.mvc.interceptor.SessionCheckInterceptor;


//@Configuration
public class InterceptorContext extends WebMvcConfigurerAdapter{
	
	/*
	<mvc:interceptors>
		<mvc:interceptor>
			<mvc:mapping path="/**"/> /**전체를 허용한다
			<bean class="kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor"/>
		</mvc:interceptor>
		
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<mvc:exclude-mapping path="/login/**"/>
			<mvc:exclude-mapping path="/js/**"/>
			<mvc:exclude-mapping path="/css/**"/>
			<mvc:exclude-mapping path="/resources/**"/>
			<bean class="kr.or.ddit.mvc.interceptor.SessionCheckInterceptor"/>
		</mvc:interceptor>
		
	</mvc:interceptors>
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new PerformanceCheckInterceptor()).addPathPatterns("/**");
		
		registry.addInterceptor(new SessionCheckInterceptor())
								.addPathPatterns("/**")
								.excludePathPatterns("/login/**")
								.excludePathPatterns("/js/**")
								.excludePathPatterns("/css/**")
								.excludePathPatterns("/resources/**");
	}
	
	
	
}
