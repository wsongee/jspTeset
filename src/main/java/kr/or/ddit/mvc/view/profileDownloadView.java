package kr.or.ddit.mvc.view;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class profileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//response content-type 설정(이미지파일이라는 것을 알려주기위해)
		response.setHeader("Content-Disposition", "attachment; filename=\""+ model.get("filepath")+"\"");
		response.setContentType("application/octet-stream"); //addHeader 메소드를 사용해도 된다. "image"로만 사용해도된다.
		
		//경로확인 후 파일 입출력을 통해 응답생성
		//파일을 읽고 응답생성

		FileInputStream fis = new FileInputStream((String) model.get("filepath"));
		ServletOutputStream sos =  response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush(); 
		sos.close();
		
	}

	
}
