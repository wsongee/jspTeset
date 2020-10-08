package kr.or.ddit.cookie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieSplitTest {

	@Test
	public void getCookieValueTest() {
		/***Given***/
		CookieSplit cookieSplit = new CookieSplit();

		/***When***/
		String cookieValue = cookieSplit.getCookieValue("USERNM");
		
				
		/***Then***/
		assertEquals("brown",cookieValue);
		
	}
	
	@Test
	public void getCookieFaileTest() {
		/***Given***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/***When***/
		String cookieValue = cookieSplit.getCookieValue("PASSWORD");
		
		
		/***Then***/
		assertEquals("brown",cookieValue);
		
	}
}
