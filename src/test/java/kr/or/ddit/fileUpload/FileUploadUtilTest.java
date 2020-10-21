package kr.or.ddit.fileUpload;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileUploadUtilTest {

	@Test
	public void getFilenameTest() {
		/***Given***/
		String contentDisposition = "from- data; name=\"img\"; filename=\"sally.png\"";

		/***When***/
		String fileName = FileUploadUtil.getFileName(contentDisposition);
		/***Then***/
		assertEquals("sally.png",fileName);
	}
}
