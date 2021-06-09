package day0609;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UseContextParam extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DD�� ���� ���ޱ�
		//HttpServlet�� �θ��� GenericServlet���� ServletConfig �ޱ�
		ServletConfig sc = getServletConfig(); //Ư�� ������ ���� ���� �� �ִ�
		//�� ���
		String name = sc.getInitParameter("name");
		String age = sc.getInitParameter("age");
		System.out.println("�̸� : "+name+"���� : "+age);
		
		//ServletContext���
		ServletContext sc1 = getServletContext();
		String common_css = sc1.getInitParameter("common_css");
		String common_js = sc1.getInitParameter("common_js");
		System.out.println("���� CSS��� : " + common_css);
		System.out.println("���� JS��� : " + common_js);
	}//doGet

}
