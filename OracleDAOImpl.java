package kr.co.sist.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.domain.UserDomain;

public class OracleDAOImpl implements DAO{
	
	public OracleDAOImpl() {
		System.out.println("OracleDAOImpl ������");
	}
	
	@Override
	public List<UserDomain> selectUser(){
		List<UserDomain> list = new ArrayList<UserDomain>();
		list.add(new UserDomain("���μ�" , "����� ������ ���ﵿ"));
		list.add(new UserDomain("�����" , "����� ���빮�� ���빮��"));
		list.add(new UserDomain("����ȣ" , "����� ���α� ���ε�"));

		return list;
	}//selectUser

}//class
