package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// pojo가 여러개라 통일하려고 interface를 만듬
public interface Controller {		//메소드 만들기			pojo는 항상 이런식으로 만들어주면 된다.
	// FC가 해야할 일을 POJO들이 대신해주는 메서드
	public String requestHandle(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException;		//리퀘스트 핸들러. 요청 오면 다뤄준다
	// 서블릿이 하는 일을 알바생이 대신 해줘야 하기 때문에. 예외처리
}
