package kr.co.sist.di.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.di.FactoryMethod;
import kr.co.sist.di.TestInjection;
import kr.co.sist.di.TestInjection2;
import kr.co.sist.di.TestInjection3;

public class RunTestInjection {
	public static void main(String[] args) {
		//1. Spring Container ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/run/appContext.xml");
		//2. ��ü ���
		//TestInjection.class�� ti�� ti1�� bean�� ����̵Ǹ� � ��ü�� ã�ƾ����� �𸣰Եȴ�
		//getBean("���̵�", reflect );
		System.out.println("������ ������ ����");
		TestInjection ti = ac.getBean("ti",TestInjection.class);
		//3. method ȣ��
		ti.useD();
		System.out.println("method ������ ����");
		//method
		TestInjection ti1 = ac.getBean("ti1", TestInjection.class);
		ti1.useD();
		
		System.out.println("�⺻�� �������� ������ ����");
		
		TestInjection2 ti2 = ac.getBean("ti2",TestInjection2.class);
		ti2.printI();
		
		System.out.println("java.lang.String ������ ����");
		TestInjection2 ti2_1 = ac.getBean("ti2_1",TestInjection2.class);
		ti2_1.printS();
		
		System.out.println("java.util.List ������ ����");
		TestInjection3 ti3List = ac.getBean("ti3List",TestInjection3.class);
		ti3List.useList();

		System.out.println("java.util.Map ������ ����");
		TestInjection3 ti3Map = ac.getBean("ti3Map",TestInjection3.class);
		ti3Map.useMap();
		
		System.out.println("singleton ��ü���");
		FactoryMethod fm = ac.getBean(FactoryMethod.class);

		if( ac != null ) {
			((ClassPathXmlApplicationContext)ac).close();
		}//end if
	}//main
}//class
