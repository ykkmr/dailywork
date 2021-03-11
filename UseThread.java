package day0311;

/**
 *	Thread�� ������� ���
 * @author user
 */
//1. Thread ���
public class UseThread extends Thread{

	//2. run method Override
	@Override
	public void run() {
		//Thread �� �����ؾ��� �ڵ�
		for(int i = 0; i < 1000 ; i ++) {
			System.out.println("run method ====" + i);
		}//end for
	}//run
	public void work() {
		//Thread �� �����ؾ��� �ڵ�
		for(int i = 0; i < 1000 ; i ++) {
			System.out.println("work ----" + i);
		}//end for
	}//run
	public static void main(String[] args) {
		//3. Ŭ���� ���� : (Thread�� �����ǰ�, UseThread�� �����ȴ�)
		UseThread ut = new UseThread();
		long st = System.currentTimeMillis();
		//4. start() ȣ�� => run()
		ut.start();
		System.out.println("--------------------------------------");
		ut.work();
		//Thread�� ����ϸ� ���α׷��� ����Ǵ� �ð��� �� �� ����
//		long et = System.currentTimeMillis();
//		System.out.println("����ð� " + ( et-st )+ "ms");
		
	}//main

}//class
