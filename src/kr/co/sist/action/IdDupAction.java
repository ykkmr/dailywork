package kr.co.sist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.dao.UserDAO;
import kr.co.sist.service.UserService;

public class IdDupAction implements Action {
	private String url;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
				UserService us = new UserService(); //���������� ó���ϴ� Ŭ������ ����
				boolean flag = us.idDupCheck(id);//���������� ����� �� ����� �޴´�
				request.setAttribute("idFlag", flag); //View���� ����� ��
				forwardFlag=true; //�̵���ļ���
			url="member/id_dup.jsp"; //�̵��� �������� ����
	}//execute

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

	@Override
	public String moveURL() {
		return url;
	}

}
