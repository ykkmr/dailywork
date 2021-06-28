package kr.co.sist.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sun.org.apache.bcel.internal.classfile.Signature;

@Component
@Aspect
public class TestAOP {
	@Before("execution( * insert(String) )") //targit method ȣ��ȴ�
	public void beforeAdvice() {
		System.out.println("AOP : ���������� �и��� �������");
	}
	
//	@Before("execution( void kr.co.sist.dao.TestDAO.before1() )")
	@Before("execution( void before1() )")
	public void before1Advice() {
		System.out.println("AOP : before1 Advice ");
	}
	
	@Before(value="execution( void before2(int) )")
	public String before2Advice( Joinpoint jp ) {
		System.out.println("AOP : before2 Advice");
		//JoinPoint�� ����ϸ� parameter�� ó���� �� �ִ�
		Object[] obj = jp.getArgs();
		System.out.println("�Ű������� ���� : " + obj.length);
		Integer paramAge = (Integer)obj[0];
		System.out.println("�Ű����� �Է°� : " + paramAge);
		org.aspectj.lang.Signature sig = jp.getSignature();
		System.out.println( sig.getName() + " / " + sig.getModifiers() );
	}
}//class
