package kr.co.sist.di;

/**
 *	�⺻�� ���������� String�� �Ű������� ������ Injection
 * @author user
 */
public class TestInjection2 {
	private int i;
	private String s;
	public TestInjection2( int i ) {
		this.i=i;
		System.out.println("�⺻�� ���������� ������ ���Թ޴� ������");
	}//TestInjection2

	public TestInjection2( String s ) {
		this.s=s;
		System.out.println("java.lang.String�� ������ ���Թ޴� ������");
	}//TestInjection2
	
	public void printI() {
		System.out.println("������ ���Թ��� �� : "+ i );
	}//printI
	
	public void printS() {
		System.out.println("������ ���Թ��� �� : "+ s );
	}//printS
	
}
