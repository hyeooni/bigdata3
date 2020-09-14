package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;

public class MemberContentController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num=Integer.parseInt(request.getParameter("num"));
		MemberDAO dao=new MemberDAO();
		MemberVO vo=dao.memberContent(num);		//회원의 하나의 정보를 담아서 넘겨줌
		// memberContent.jsp 로 가게 해주자. 알바생은 객체바인딩까지. 포워딩 해야하니까
		request.setAttribute("vo", vo);
		
		return "member/memberContent.jsp";
	}

}
