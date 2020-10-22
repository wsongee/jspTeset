package kr.or.ddit.fileUpload;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUploadUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);
	
	@Test
	public void getFilenameTest() {
		/***Given***/
		String contentDisposition = "from- data; name=\"img\"; filename=\"sally.png\"";

		/***When***/
		String fileName = FileUploadUtil.getFileName(contentDisposition);
		/***Then***/
		assertEquals("sally.png",fileName);
	}
	@Test
	public void UUDItest() {
		/***Given***/
		

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}",uuid);

		/***Then***/
	}
	
	public void getExtenstionFailTest() {
		/***Given***/
		String filename= "png";

		/***When***/
		String ext = FileUploadUtil.getFileName(filename);
		
		/***Then***/
		assertEquals("", ext);
	}
}
