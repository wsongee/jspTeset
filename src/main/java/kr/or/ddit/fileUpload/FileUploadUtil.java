package kr.or.ddit.fileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ContentDisposition;

public class FileUploadUtil {
	// from- data; name="img"; filename="sally.png"
	// ==> sally.png

	// FileUploadUtilTest
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

	public static String getFileName(String contentDisposition) {

		String[] name1 = contentDisposition.split("; ");
		for (int i = 0; i < name1.length; i++) {
			String[] name2 = name1[i].split("=");
			if (name2[0].equals("filename")) {
				return name2[1].replaceAll("\"", "");
			}
		}

		return "";
	}

	// filename : sally.png ==> png
	public static String getExtenstion(String filename) {
		
		if (filename == null||filename.indexOf(".")==-1)
			return "";
		else {
			return filename.split("\\.")[1];
			
//		//sally.png
//		String[] p1 = filename.split("\\.");
//		for(int i =0; i<p1.length; i++) {
//			return p1[1];
//		}
//		return "";
		}
	}
}
