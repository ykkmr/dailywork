package kr.co.sist.dao;

import org.springframework.stereotype.Component;

@Component
public class TestDAO {
	public void insert(String name) {
		System.out.println("DAO DB작업 처리 : "+name+"님이 추가되었습니다");
	}//insert
	
	public void before1() {
		System.out.println("DAO : 매개변수 없고 반환형 없는 target");
	}
	public String before2(int age) {
		String msg="";
		System.out.println("DAO : 매개변수 있고, 반환형이 없는 target");
		return msg;
	}
}//class
