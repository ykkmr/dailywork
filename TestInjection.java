package kr.co.sist.di;

import kr.co.sist.dao.DAO;
import kr.co.sist.domain.UserDomain;

/**
 *	�پ��� ������ ���� ����
 *	������ ������ ����, method������ ����
 * @author user
 */
public class TestInjection {
//������ ������ ����
	private DAO d;
	
	public TestInjection() {
		System.out.println("method ������ ���Կ� �ݵ�� ���Ǵ� �⺻ ������");
	}//TestInjection
	
	public TestInjection(DAO d) {
		this.d=d;
		System.out.println("������ ������ ����");
	}//TestInjection
	
	public void setD(DAO d) {
		this.d=d;
		System.out.println("method ������ ����");
	}//setD
	
	public void useD() {
		for( UserDomain ud : d.selectUser() ) {
			System.out.println( ud.getName() );
		}//end for
	}//useD
	
}
