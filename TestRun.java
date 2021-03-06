package kr.co.sist.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.service.TestService;

public class TestRun {

	public static void main(String[] args) {
		//1. Spring Container 생성
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/run/appContext.xml");
		//2. bean 얻기
		TestService ts = ac.getBean( TestService.class );
		
		//3. 업무처리 method 호출
//		ts.add("송준희");
		ts.callBefore1(); //매개변수 없고 반환형 없는 method 시작 전 Advice호출된다
		ts.callBefore2(29);
		if( ac != null) {
			((ClassPathXmlApplicationContext)ac).close();
		}//end if
	}//main

}//class
