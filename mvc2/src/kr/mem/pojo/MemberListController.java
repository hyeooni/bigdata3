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
		// ��ü���ε�
		request.setAttribute("list", list);
		// View -> member/memberList.jsp
		// ������ �ϴ� �κ��� �ߺ� �� ���ɼ��� ����. �������� frontcontroller��. ��� �˹ٻ��� �ϸ� �ߺ� �� ���� ����
		return "member/memberList.jsp";	//member/?
		// /WEB-INF/views ���� ������. �Ź� �� �ʿ� x�ϱ� ������
	}


}
