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
		//서블릿은 데이터처리를 한다
		List<LoginDataVO> list = new ArrayList<LoginDataVO>();
		list.add(new LoginDataVO("이학민","lee@sist.co.kr"));
		list.add(new LoginDataVO("한상민","han@daum.net"));
		list.add(new LoginDataVO("진재혁","jin@naver.com"));
		list.add(new LoginDataVO("강인섭","kang@gmail.com"));
		
		//처리된 데이터를 view객체에서 사용하기 위해 Scope객체에 설정한다
		request.setAttribute("data", list);
		
		//서블릿은 View를 생성하기 어려우므로 View는 JSP에서 작성한다
		//이동할 페이지 설정
		RequestDispatcher rd = request.getRequestDispatcher("day0607/test.jsp");
		//이동
		rd.forward(request, response);
		
	}//doGet

}//class
