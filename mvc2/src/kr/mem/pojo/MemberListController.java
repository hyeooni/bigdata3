package kr.mem.pojo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;

public class MemberListController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao=new MemberDAO();
		ArrayList<MemberVO> list=dao.memberAllList();
		// 객체바인딩
		request.setAttribute("list", list);
		// View -> member/memberList.jsp
		// 포워딩 하는 부분이 중복 될 가능성이 많음. 포워딩은 frontcontroller로. 모든 알바생이 하면 중복 될 수도 있음
		return "member/memberList.jsp";	//member/?
		// /WEB-INF/views 까지 공통경로. 매번 쓸 필요 x니까 지우자
	}


}
