package kr.co.sist.di;

/**
 *	Singleton pattern�� ����� Ŭ����
 * @author user
 */
public class FactoryMethod {
	private static FactoryMethod fm;
	
	private FactoryMethod() {
		
	}
	
	public static FactoryMethod getInstance() {
		if(fm == null) {
			fm = new FactoryMethod();
		}//end if
		System.out.println("getInstance method�� factory-method�� ȣ��");
		return fm;
	}//getInstance
	
	
}
