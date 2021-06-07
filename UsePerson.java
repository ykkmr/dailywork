package day0607;

public class UsePerson {
	
	/**
	 *  Interface�� ������������ ������ Ŭ������ ���
	 */
	public void noneInterface() {
		// Ŭ������ method�� ���� �ٸ� �̸��� �����Ƿ� ��ü���� �� ���� �ٸ� �̸�����
		// method�� ȣ���Ͽ� ����ؾ��Ѵ� (����)
		SangMin sm = new SangMin();
		HakMin hm = new HakMin();
		JaeHyck jh = new JaeHyck();
		
		System.out.println( sm.msg() );
		System.out.println( hm.msg1() );
		System.out.println( jh.msg2() );
	}
	
	/**
	 *  Interface�� ������ ������ Ŭ������ ���
	 */
	public void useInterface() {
		// Ŭ������ method�� ������ �̸��� �����Ƿ� ��ü���� �� ���� �̸�����
		// method�� ȣ���Ͽ� ����ؾ��Ѵ� (���)
		SangMin2 sm = new SangMin2();
		HakMin2 hm = new HakMin2();
		JaeHyck2 jh = new JaeHyck2();
		
		System.out.println( sm.execute() );
		System.out.println( hm.execute() );
		System.out.println( jh.execute() );
	}
	
	public static void main(String[] args) {
		UsePerson up = new UsePerson();
		up.noneInterface();
		System.out.println("----------------------------------------");
		up.useInterface();
	}//main

}//class
