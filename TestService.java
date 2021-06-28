package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.TestDAO;

@Component
public class TestService {
	@Autowired(required = false)
	private TestDAO tDAO;
	
	public void add(String name) {
		System.out.println("Service : �������� ó��");
		tDAO.insert(name);
	}//add

	public void callBefore1() {
		System.out.println("Service : �������� ó��");
		tDAO.before1();//DAO����ó��
	}

	public void callBefore2() {
		System.out.println("Service : �������� ó��");
		tDAO.before2(getArgs);//DAO����ó��
	}
}//class
