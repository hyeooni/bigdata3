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
		// 1. (클라이언트로부터 )어떤 요청인지 파악하는 작업 -> *.do			 - 어떤 요청인지 판단하는 방법
		String reqUrl=request.getRequestURI();		//어떤 요청인지 uri정보를 얻어올 수 있음
		//System.out.println(reqUrl);	어떤 요청을 했는지 경로를 가져 올 수 있음
		String ctxPath = request.getContextPath();		//경로 가져오기		////경로바꾸기에서!여기는 req아니까 쓰기
	    //System.out.println(ctxPath);		결과 -> /mvc1
	    // 클라이언트가 요청한 명령.			이 command를 찾으려 동분서주
	    String command=reqUrl.substring(ctxPath.length());
	    System.out.println(command);		// 결과 -> /insert.do
	    
	    //각 요청에 따라 처리하기(분기작업)
	    Controller controller = null;
//	    MemberDAO dao=new MemberDAO(); 이제 알바생이 하니까 없어도 된당
	    String nextView=null;
	    HandlerMapping mappings= new HandlerMapping();
	    controller=mappings.getController(command);
	    nextView=controller.requestHandle(request, response);
	    // 핸들러매핑
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
	    	//response.sendRedirect("member/member.html");		//위 아래 모두 가능. 아래가 경로면에서 더 좋음
	    	controller = new MemberInsertFormController();
	    	nextView=controller.requestHandle(request, response);
	    }else if(command.equals("/delete.do")) {
	    	controller = new MemberDeleteController();
	    	nextView=controller.requestHandle(request, response);
	    	}
	    */
	    //View 페이지로 연동하는 부분
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
//Controller(Servlet)	- FrontController (Servlet 만듬)
//		- Controller(Action, Pojo)	(Pojo로 만듬 뭘까? 그냥 자바! 서블릿 형태 말고 예전부터 있었던 그냥 자바 클래스로 만들겠다)
//				(일반적인 자바 오브젝트)
