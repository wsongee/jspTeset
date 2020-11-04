package kr.or.ddit.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPoolServlet extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolServlet.class);
	@Override
	public void init() throws ServletException {
		logger.debug("dbConnectionPoolServlet init()");
		
		//Connection Pool Servlet이 초기화 될때 커넥션 풀을 생성해서
		//application 영역에 저장
		//다른 jsp, servlet에서는 application 영역을 통해 커넥션 풀을 접근
		
		//커넥션 pool 생성
		BasicDataSource bd = new BasicDataSource();
		bd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bd.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		bd.setUsername("SONGI");
		bd.setPassword("java");
		bd.setInitialSize(20);
		
		ServletContext sc = getServletContext();
		sc.setAttribute("bd", bd);
	}
};
