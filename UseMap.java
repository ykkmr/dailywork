package day0607;

import java.util.HashMap;
import java.util.Map;

public class UseMap {
	
	/**
	 * interface�� �������� �ʴ� Ŭ������ ����Ͽ� Map�� �߰��ϰ� �� ���
	 */
	public  void noneUseInterface() {
		//1. Map��ü ����
		Map map = new HashMap();
		//2. ������ ��� ��ü�� Map �߰�
		map.put("lee", new HakMin());
		map.put("jin", new JaeHyck());
		map.put("han", new SangMin());
		//3. Ű�� ����� Map��ü ���
		String key = "lee";//jin, han
		//�������̽��� ������� ������ Ű�� ����Ͽ� ��ü�� ã��, ��ü�� �����ϴ� ����
		//4���� ������ �������Ѵ�. ���� ���� ������ �� �Ͽ� ���� �ڵ带 ���� �� ����.
		if("lee".equals(key)) {
			HakMin hm = (HakMin)map.get(key);
			System.out.println(hm.msg1());
		}
		if("jin".equals(key)) {
			JaeHyck jh = (JaeHyck)map.get(key);
			System.out.println(jh.msg2());
		}
		if("han".equals(key)) {
			SangMin sm = (SangMin)map.get(key);
			System.out.println(sm.msg());
		}
		
	}//noneUseInterface

	/**
	 * interface�� ������ Ŭ������ ����Ͽ� Map�� �߰��ϰ� �����
	 */
	public  void useInterface() {
		Map<String,Person> map = new HashMap<String,Person>();
		//2. ������ ��� ��ü�� Map �߰�
		map.put("lee", new HakMin2());
		map.put("jin", new JaeHyck2());
		map.put("han", new SangMin2());
		//3. Ű�� ����� Map��ü ���
		String key = "lee";//jin, han
		//3. Ű�� ����� Map��ü ��� : Override�� method�� ȣ���ϸ� �ڽ�Ŭ������ method�� ȣ��ȴ� (������ ���� �ϴ� �ڵ带 ���� �� �ִ�)
		if( map.containsKey(key)) {
			Person person = map.get(key); //Ű�� ã�Ƴ� �ڽ��� �θ�� �޴´�
			//�θ��� method�� ȣ���ϸ� �ڽ�Ŭ������ method�� ȣ��ȴ� Overrider
			System.out.println(person.execute()); 
		}//end if
	}//useInterface

	public static void main(String[] args) {
		UseMap um = new UseMap();
		um.noneUseInterface();
		System.out.println("----------------------------------------");
		um.useInterface();
	}//main

}//class
