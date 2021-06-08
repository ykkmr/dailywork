package kr.co.sist.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import kr.co.sist.dao.UserDAO;
import kr.co.sist.util.cipher.DataEncrypt;
import kr.co.sist.vo.WebMemberVO;

/**
 *	Business Logic ó��
 * @author user
 */
public class UserService {
	/**
	 * 	�Էµ� ���̵� ��������� üũ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean idDupCheck(String id){
		boolean flag = false;
		//���������� ���� : �Էµ� ���̵� ����Ͽ� ��ȸ�� ����� boolean���� ����� ��
		UserDAO ud = new UserDAO();
		
		try {
			flag = "".equals(ud.selectId(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//idDupCheck
	
	/**
	 * �Էµ� VO�� ������ ��й�ȣ�� SHA�� ��ȯ�� �� DBMS�� �߰��ϴ� ��
	 * @param wmVO
	 * @throws NullPointerException 
	 */
	public void addMember(WebMemberVO wmVO) throws NullPointerException , SQLException{
		//�������� : ��й�ȣ�� �� �� ������ �����Ѵ�
		try {
			wmVO.setPass(DataEncrypt.messageDigest("SHA-1", wmVO.getPass()));
			UserDAO ud = new UserDAO();
			ud.insertMember(wmVO);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//end catch
	}
}//class
