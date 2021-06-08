package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	��� Action Ŭ�������� �ؾ��� �ϵ��� ����� ���� 
 *	�Ķ����ó��, ���������� ����������, ���������� ����, ��������, �������̵���ļ���
 * @author user
 */
public interface Action {

//		private String url;
//		private boolean isForward;
		
		/**
		 * �Ķ������ ó��, ��ȿ�� ����, ����������ü�� ���
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
		
		/**
		 * �̵������ ����
		 * @return true - forward, false - redirect
		 */
		public boolean isForward();
		/**
		 * �̵��������� URL
		 * @return
		 */
		public String moveURL();
}
