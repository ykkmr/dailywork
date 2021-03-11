package day0311;

/**
 *	�����ֱ� ( ready -> running <-> block )
 * @author user
 */
//1. Runnable ����
public class UseSleep implements Runnable{

	//2. run method override
	@Override
	public void run() {
		//Thread�� �����ؾ��� �ڵ�
		for(int i = 0; i < 10 ; i ++) {
			System.out.println("i = "+ i);
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//end catch
		}//end for
	}//run
	
	public static void main(String[] args) {
		//3. Ŭ���� ����
		UseSleep us = new UseSleep();
		//4. Thread�� has a ���� ����
		Thread thread = new Thread( us );
		//5. start();
		thread.start();

	}//main

}//class
