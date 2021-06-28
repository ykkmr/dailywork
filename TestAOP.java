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
	@Before("execution( * insert(String) )") //targit method 호출된다
	public void beforeAdvice() {
		System.out.println("AOP : 업무로직과 분리된 공통로직");
	}
	
//	@Before("execution( void kr.co.sist.dao.TestDAO.before1() )")
	@Before("execution( void before1() )")
	public void before1Advice() {
		System.out.println("AOP : before1 Advice ");
	}
	
	@Before(value="execution( void before2(int) )")
	public String before2Advice( Joinpoint jp ) {
		System.out.println("AOP : before2 Advice");
		//JoinPoint를 사용하면 parameter를 처리할 수 있다
		Object[] obj = jp.getArgs();
		System.out.println("매개변수의 갯수 : " + obj.length);
		Integer paramAge = (Integer)obj[0];
		System.out.println("매개벼수 입력값 : " + paramAge);
		org.aspectj.lang.Signature sig = jp.getSignature();
		System.out.println( sig.getName() + " / " + sig.getModifiers() );
	}
}//class
