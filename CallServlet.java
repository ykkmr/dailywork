package day0513;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
// HttpServlet��� : �Ϲ� Ŭ������ �����񽺸� �ϱ� ���ؼ�
public class CallServlet extends HttpServlet {
	//2. �����ڰ� ��û�� ����� ó���� �� �ִ� method�� Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3. ������ ���� : �����ڿ��� ������ �������� ����
		response.setContentType("text/html;charset=UTF-8");
		//4. ������ ���Ͽ� �����ڿ��� ������ ������ �������� ��Ʈ�� ���
		PrintWriter out = response.getWriter();
		//5. �����ڿ��� ������ ������ ��Ʈ�� ���
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>GET����� ��û�� ���� �� ����</title>");
		out.println("</head>");
		out.println("<body>"); //�ҽ����� ���� �� ��� �� �� ����
		out.print("<strong style='backgroind-color:#FF0000'>"); //�ҽ����� ���� �� ��� �� �� ������ ���� �ʴ´�
		out.print( request.getMethod() );
		out.println( "</strong>������� ��û���� ���� ����<br/>" );
		out.println( "<a href='javascript:history.back();'>�ڷ�</a>" );
		out.println("</body>");
		out.println("</html>");
	}//doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post��� ��û");
		//3. ������ ���� : �����ڿ��� ������ �������� ����
		response.setContentType("text/html;charset=UTF-8");
		//4. ������ ���Ͽ� �����ڿ��� ������ ������ �������� ��Ʈ�� ���
		PrintWriter out = response.getWriter();
		//5. �����ڿ��� ������ ������ ��Ʈ�� ���
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>POST����� ��û�� ���� �� ����</title>");
		out.println("</head>");
		out.println("<body>"); //�ҽ����� ���� �� ��� �� �� ����
		out.print("<strong style='backgroind-color:#FF0000'>"); //�ҽ����� ���� �� ��� �� �� ������ ���� �ʴ´�
		out.print( request.getMethod() );
		out.println( "</strong>������� ��û���� ���� ����<br/>" );
		out.println( "<a href='http://localhost/servlet_prj/common/day0513/call_servlet.html'>�ڷ�</a>" );
		out.println("</body>");
		out.println("</html>");
	}//doPost
}//class
