package day0311;

/**
 *	Runnable�� �����Ͽ� Thread ���
 * @author user
 */
public class UseRunable implements Runnable{
	
	//2. run() Override
	@Override
	public void run() {
		//Thread�� ������ �ڵ� ( ���ÿ� �����ؾ��� �ڵ� )
		for(int i = 0; i < 1000 ; i ++) {
			System.out.println( "run i ======" + i );
		}//end for
	}//run
	
	public void work() {
		//Thread�� ������ �ڵ� ( ���ÿ� �����ؾ��� �ڵ� )
		for(int i = 0; i < 1000 ; i ++) {
			System.out.println( "work i =" + i );
		}//end for
	}//run

	public static void main(String[] args) {
		//3. Ŭ������ ��üȭ
		UseRunable ur = new UseRunable();
		//4. ThreadŬ������ ��üȭ has a ���� ����
		Thread thread = new Thread( ur );
		//5. start()ȣ��
		thread.start();
		System.out.println("-----------------------");
		ur.work();
	}//main

}//class
