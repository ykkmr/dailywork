package day0607;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Move extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ ������ó���� �Ѵ�
		List<LoginDataVO> list = new ArrayList<LoginDataVO>();
		list.add(new LoginDataVO("���й�","lee@sist.co.kr"));
		list.add(new LoginDataVO("�ѻ��","han@daum.net"));
		list.add(new LoginDataVO("������","jin@naver.com"));
		list.add(new LoginDataVO("���μ�","kang@gmail.com"));
		
		//ó���� �����͸� view��ü���� ����ϱ� ���� Scope��ü�� �����Ѵ�
		request.setAttribute("data", list);
		
		//������ View�� �����ϱ� �����Ƿ� View�� JSP���� �ۼ��Ѵ�
		//�̵��� ������ ����
		RequestDispatcher rd = request.getRequestDispatcher("day0607/test.jsp");
		//�̵�
		rd.forward(request, response);
		
	}//doGet

}//class
