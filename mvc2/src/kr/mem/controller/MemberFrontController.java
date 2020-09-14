package kr.mem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.pojo.Controller;

public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		// 1. (Ŭ���̾�Ʈ�κ��� )� ��û���� �ľ��ϴ� �۾� -> *.do			 - � ��û���� �Ǵ��ϴ� ���
		String reqUrl=request.getRequestURI();		//� ��û���� uri������ ���� �� ����
		//System.out.println(reqUrl);	� ��û�� �ߴ��� ��θ� ���� �� �� ����
		String ctxPath = request.getContextPath();		//��� ��������		////��ιٲٱ⿡��!����� req�ƴϱ� ����
	    //System.out.println(ctxPath);		��� -> /mvc1
	    // Ŭ���̾�Ʈ�� ��û�� ���.			�� command�� ã���� ���м���
	    String command=reqUrl.substring(ctxPath.length());
	    System.out.println(command);		// ��� -> /insert.do
	    
	    //�� ��û�� ���� ó���ϱ�(�б��۾�)
	    Controller controller = null;
//	    MemberDAO dao=new MemberDAO(); ���� �˹ٻ��� �ϴϱ� ��� �ȴ�
	    String nextView=null;
	    HandlerMapping mappings= new HandlerMapping();
	    controller=mappings.getController(command);
	    nextView=controller.requestHandle(request, response);
	    // �ڵ鷯����
	    // /list.dp---->MemberListController(HandlerMapping)
	    // /insert.do-->MemberInsertController
	    // /insertForm.do-->MemberInsertFormController
	    // /delete.do	 ==>MemberDeleteController
	    /*
	    if(command.equals("/list.do")) {
	    	controller = new MemberListController();
	    	nextView=controller.requestHandle(request,response);
	    }else if(command.equals("/insert.do")) {
		    controller = new MemberInsertController();
	    	nextView=controller.requestHandle(request, response);
	    }else if(command.equals("/insertForm.do")) {
	    	//response.sendRedirect("member/member.html");		//�� �Ʒ� ��� ����. �Ʒ��� ��θ鿡�� �� ����
	    	controller = new MemberInsertFormController();
	    	nextView=controller.requestHandle(request, response);
	    }else if(command.equals("/delete.do")) {
	    	controller = new MemberDeleteController();
	    	nextView=controller.requestHandle(request, response);
	    	}
	    */
	    //View �������� �����ϴ� �κ�
	    if(nextView!=null) {
	    	if(nextView.indexOf("redirect:")!=-1) {
	    		String[] sp=nextView.split(":");	//	sp[0]:sp[1]
	    		response.sendRedirect(sp[1]);	// :0
	    	}else {
	    		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/"+nextView);
	    		rd.forward(request, response);
	    	}
		}
	}
}
//1.Action
//2. Pojo	(Plain Old Java Object)
//
//Controller(Servlet)	- FrontController (Servlet ����)
//		- Controller(Action, Pojo)	(Pojo�� ���� ����? �׳� �ڹ�! ���� ���� ���� �������� �־��� �׳� �ڹ� Ŭ������ ����ڴ�)
//				(�Ϲ����� �ڹ� ������Ʈ)
