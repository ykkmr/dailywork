package kr.co.sist.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.domain.UserDomain;

public class MySqlDAOImpl implements DAO{
	
	public MySqlDAOImpl() {
		System.out.println("MySqlDAOImpl ������");
	}
	
	@Override
	public List<UserDomain> selectUser(){
		List<UserDomain> list = new ArrayList<UserDomain>();
		list.add(new UserDomain("�ǿ���" , "����� ���ʱ� ���ʵ�"));
		list.add(new UserDomain("������" , "����� ���ı� ������"));
		list.add(new UserDomain("����ȣ" , "����� ���α� ���ε�"));
		list.add(new UserDomain("�����" , "����� ������"));

		return list;
	}

}
