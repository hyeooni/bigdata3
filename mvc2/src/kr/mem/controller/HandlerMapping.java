package kr.mem.controller;

import java.util.HashMap;

import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberContentController;
import kr.mem.pojo.MemberDeleteController;
import kr.mem.pojo.MemberInsertController;
import kr.mem.pojo.MemberInsertFormController;
import kr.mem.pojo.MemberListController;
import kr.mem.pojo.MemberUpdateController;

public class HandlerMapping {
	//		 			K, V
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		initMap();
	}
	//★★★★★★★★★★★★★
	private void initMap() {		//이런 작업 여기서 하려한다
		try {
		    // /list.dp---->MemberListController(HandlerMapping)
		    // /insert.do-->MemberInsertController
		    // /insertForm.do-->MemberInsertFormController
		    // /delete.do	 ==>MemberDeleteController
			mappings.put("/list.do", new MemberListController());	//객체니까 생성해서 넣어주기
			mappings.put("/insert.do", new MemberInsertController());
			mappings.put("/insertForm.do", new MemberInsertFormController());
			mappings.put("/delete.do", new MemberDeleteController());
			mappings.put("/content.do", new MemberContentController());
			mappings.put("/update.do", new MemberUpdateController());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}

}
