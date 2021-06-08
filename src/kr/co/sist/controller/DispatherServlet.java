package kr.co.sist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;
import kr.co.sist.action.IdDupAction;
import kr.co.sist.action.MemberFormAction;
import kr.co.sist.action.MemberProcessAction;

@SuppressWarnings("serial")
public class DispatherServlet extends HttpServlet {
	
	private static Map<String, Action> map = new HashMap<String, Action>();
	
	@Override
	public void init() {//���� �����ڰ� �������� ��û���� �� �ѹ��� ȣ�� �Ǵ� method
		//Map�� ����
		map.put("M001", new MemberFormAction());//ȸ������ ���
		map.put("D001", new IdDupAction());//�ߺ�Ȯ��
		map.put("M002", new MemberProcessAction());//ȸ������ ó��
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GET������� ��û�ϸ� post��Ŀ��� ó��
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������� �ѱ�ó���� �ϸ� ��� Action���� �ѱ� ó���� ���� �ʾƵ� �ȴ�
		request.setCharacterEncoding("UTF-8");//POST����� Encoding(GET����� ��û�� ������ �������� �ʴ´�)
		
		String cmd = request.getParameter("cmd");
		if( cmd == null ) {//����Ǵ� Action�� �����ϵ��� ����� �ܺ� �Է°�
			cmd="M001";//cmd�� ���ٸ� ȸ������ ���� �����ִ� cmd�� �����Ѵ�
		}//end if
		
		Action action = map.get(cmd); //�Էµ� cmd���� �ش��ϴ� action�� �ڽ�Ŭ������ map���� ã�� �����´�
		
		if(action == null) {//cmd���� �ܺο��� �Ѽ��Ͽ� �ٸ� ������ �Է� ���� �� 
			action = map.get("M001"); //����ȭ������ �����Ѵ�
		}//end if
		
		//������ action�� methodȣ��(Override�� �ڽ�Ŭ������ method�� ȣ��)
		
		action.execute(request, response); //�Ķ����ó��, ��ȿ�� ����, service��ü�� ���
		String url = action.moveURL();
		boolean isForward= action.isForward();
		
		move(request, response, url, isForward);
	}//doPost

	public void move(HttpServletRequest request, HttpServletResponse response, String url, boolean forwardFlag)
	 throws ServletException, IOException {
		if(forwardFlag) { //forward�� �̵�
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}else { //redirect�� �̵�
			response.sendRedirect(url);
		}//end else
	}//move
	
}//class
