package kr.co.sist.dao;

import java.util.List;

import kr.co.sist.domain.UserDomain;

/**
 *	���� Ŭ�������� �ݵ�� ���� �ؾ��� ������ ��� ����
 * @author user
 */
public interface DAO {

	public List<UserDomain> selectUser();
	
}
