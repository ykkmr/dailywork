package day0607;

public class UsePerson {
	
	/**
	 *  Interface를 구현하지않은 상태의 클래스를 사용
	 */
	public void noneInterface() {
		// 클래스의 method가 각각 다른 이름을 가지므로 객체생성 후 각각 다른 이름으로
		// method를 호출하여 사용해야한다 (불편)
		SangMin sm = new SangMin();
		HakMin hm = new HakMin();
		JaeHyck jh = new JaeHyck();
		
		System.out.println( sm.msg() );
		System.out.println( hm.msg1() );
		System.out.println( jh.msg2() );
	}
	
	/**
	 *  Interface를 구현한 상태의 클래스를 사용
	 */
	public void useInterface() {
		// 클래스의 method가 동일한 이름을 가지므로 객체생성 후 같은 이름으로
		// method를 호출하여 사용해야한다 (편안)
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
