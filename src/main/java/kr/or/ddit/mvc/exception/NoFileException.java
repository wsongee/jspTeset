package kr.or.ddit.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//사용자에게 500 에러대신 404(NOT_FOUND) 응답코드로 응답이 가게끔 설정한다.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileException extends Exception{

	
}
