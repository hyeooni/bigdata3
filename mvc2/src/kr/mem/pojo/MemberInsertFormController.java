package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertFormController implements Controller{
	
	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//String page="member/member.html";
		return "member/member.jsp";
		// /WEB-INF/member/요거 지운거 어딘가에 넣어줘야 함.
		// /WEB-INF/views/가 경통
	
	}

}
