package kr.co.sist.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.UserService;
import kr.co.sist.vo.WebMemberVO;

public class MemberProcessAction implements Action {
	private String url;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ķ���� �� �ޱ�
		//VO�Ķ���� �� �߰�
		WebMemberVO wmVO = new WebMemberVO(request.getParameter("member_id"),
				request.getParameter("member_pass"),request.getParameter("member_name"),
				request.getParameter("email")+"@"+request.getParameter("domain"),
				request.getParameter("birth"), request.getParameter("tel"));
		
		//���������� ���
		UserService us = new UserService();
		try {
			us.addMember(wmVO);
			//�̵��� �������� ��� ����
			url="member/member_join_result.jsp";
			forwardFlag = true;
			request.setAttribute("addMemberFlag", true); //�������� ��� ����
		}catch(SQLException se) {
			request.setAttribute("addMemberFlag", false); //�� �������� ��� ����
			se.printStackTrace();
		}catch(NullPointerException npe) {
			url="http://localhost/model2_prj2/member/member_fail.html";
			forwardFlag = false;
		}//end catch
		
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

	@Override
	public String moveURL() {
		return url;
	}

}
