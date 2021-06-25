package kr.co.sist.di.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.di.DependencyService;

public class RunAutowired {

	public static void main(String[] args) {

		//1. Spring Container ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/appContext2.xml");
		//2. bean ��� (������ ���Թ��� ��ü ���)
		DependencyService ds = ac.getBean(DependencyService.class);
		//3. bean ���
		System.out.println( ds.searchList() );
		
		//4. Spring Container �ݱ�
		if( ac != null ) {
			((ClassPathXmlApplicationContext)ac).close();
		}//end if
		
	}//main

}//class
