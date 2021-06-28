package kr.co.sist.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.service.TestService;

public class TestRun {

	public static void main(String[] args) {
		//1. Spring Container ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/run/appContext.xml");
		//2. bean ���
		TestService ts = ac.getBean( TestService.class );
		
		//3. ����ó�� method ȣ��
//		ts.add("������");
		ts.callBefore1(); //�Ű����� ���� ��ȯ�� ���� method ���� �� Adviceȣ��ȴ�
		ts.callBefore2(29);
		if( ac != null) {
			((ClassPathXmlApplicationContext)ac).close();
		}//end if
	}//main

}//class
