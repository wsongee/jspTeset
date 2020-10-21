package kr.or.ddit.fileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	//from- data; name="img"; filename="sally.png"
	//==> sally.png
	
	//FileUploadUtilTest
	
	public static String getFileName(String contentDisposition) {
		
		String[] name1 = contentDisposition.split("; ");
		for(int i =0; i< name1.length; i++) {
			String[] name2 = name1[i].split("=");
			if(name2[0].equals("filename")) {
				return name2[1].replaceAll("\"", "");
			}
		}
		
		return "";
	}
}
