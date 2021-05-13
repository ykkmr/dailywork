package day0513;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
// HttpServlet상속 : 일반 클래스로 웹서비스를 하기 위해서
public class CallServlet extends HttpServlet {
	//2. 접속자가 요청한 방식을 처리할 수 있는 method를 Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3. 응답방식 설정 : 접속자에게 보내줄 파일형식 설정
		response.setContentType("text/html;charset=UTF-8");
		//4. 생성된 파일에 접속자에게 보내줄 내용을 쓰기위한 스트림 얻기
		PrintWriter out = response.getWriter();
		//5. 접속자에게 보내줄 내용을 스트림 기록
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>GET방식의 요청이 있을 때 응답</title>");
		out.println("</head>");
		out.println("<body>"); //소스보기 했을 때 출력 후 줄 변경
		out.print("<strong style='backgroind-color:#FF0000'>"); //소스보기 했을 때 출력 후 줄 변경을 하지 않는다
		out.print( request.getMethod() );
		out.println( "</strong>방식으로 요청했을 때의 응답<br/>" );
		out.println( "<a href='javascript:history.back();'>뒤로</a>" );
		out.println("</body>");
		out.println("</html>");
	}//doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식 요청");
		//3. 응답방식 설정 : 접속자에게 보내줄 파일형식 설정
		response.setContentType("text/html;charset=UTF-8");
		//4. 생성된 파일에 접속자에게 보내줄 내용을 쓰기위한 스트림 얻기
		PrintWriter out = response.getWriter();
		//5. 접속자에게 보내줄 내용을 스트림 기록
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>POST방식의 요청이 있을 때 응답</title>");
		out.println("</head>");
		out.println("<body>"); //소스보기 했을 때 출력 후 줄 변경
		out.print("<strong style='backgroind-color:#FF0000'>"); //소스보기 했을 때 출력 후 줄 변경을 하지 않는다
		out.print( request.getMethod() );
		out.println( "</strong>방식으로 요청했을 때의 응답<br/>" );
		out.println( "<a href='http://localhost/servlet_prj/common/day0513/call_servlet.html'>뒤로</a>" );
		out.println("</body>");
		out.println("</html>");
	}//doPost
}//class
