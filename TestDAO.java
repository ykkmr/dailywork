package kr.co.sist.dao;

import org.springframework.stereotype.Component;

@Component
public class TestDAO {
	public void insert(String name) {
		System.out.println("DAO DB�۾� ó�� : "+name+"���� �߰��Ǿ����ϴ�");
	}//insert
	
	public void before1() {
		System.out.println("DAO : �Ű����� ���� ��ȯ�� ���� target");
	}
	public String before2(int age) {
		String msg="";
		System.out.println("DAO : �Ű����� �ְ�, ��ȯ���� ���� target");
		return msg;
	}
}//class
