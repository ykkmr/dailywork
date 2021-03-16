package day0315;

/**
 *	���� Ŭ������ �ۼ����� �ʰ�, �������̽��� ���� ����ϴ� ���
 * @author user
 */

/**
 *
 * @author user
 */
public interface UseLambda {

	public abstract void method(Inter1 in1);//

	public static void main(String[] args) {
		

		//���� : () -> { };
		
		Inter1 in1 = () -> { System.out.println("��ȯ�� ���� �Ű����� ���� ���� method ���� : "); };
		//ȣ�� : method�� ȣ���ϸ� lambda������ ������ �ڵ尡 ����ȴ�.
		in1.test();
		
		//�Ű��������� �޶� �ȴ�
		Inter2 int2 = (String name)->{ System.out.println("��ȯ�� ����, �Ű����� �ִ� ���� method���� : "+name);}; 
		//ȣ��
		int2.test("�ڱ��");
		
		//��ȯ�� 
		Inter3 in3 = () -> { return "������ ������";};
		String msg = in3.test();
		System.out.println("��ȯ�� �ְ�, �Ű����� ���� ���� method���� : "+msg);
		
		Inter4 in4 = (String name )->{return name +"�� �ȳ��ϼ���?"; };
		msg = in4.test("�ڱ��");
		System.out.println("��ȯ�� �ְ�, �Ű����� �ִ� ���� method���� : " +msg);
		
		
		//1~100���� "Thread"�� ����Ͽ� ����ϴ� �ڵ� �ۼ�
		
		Thread t = new Thread (()-> { 
									for(int i = 1; i < 101 ; i ++) {
										System.out.println(i);
										}
								} );
		
		t.start();
		System.out.println("----------------------------");
		UseLambda ul = new UseLambda();
//		ul.method(in1); //Lambda���� ����Ͽ� ������ ��ü�� �Ҵ�
		ul.method( ()->{System.out.println("�Ű������� ���ǵ� lambda"); } );
		
	}//main

}//class
