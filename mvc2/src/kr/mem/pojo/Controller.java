package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// pojo�� �������� �����Ϸ��� interface�� ����
public interface Controller {		//�޼ҵ� �����			pojo�� �׻� �̷������� ������ָ� �ȴ�.
	// FC�� �ؾ��� ���� POJO���� ������ִ� �޼���
	public String requestHandle(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException;		//������Ʈ �ڵ鷯. ��û ���� �ٷ��ش�
	// ������ �ϴ� ���� �˹ٻ��� ��� ����� �ϱ� ������. ����ó��
}
