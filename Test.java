package day0315;

public class Test {
	
	public Test() throws ClassNotFoundException{
		Class.forName("day0315.Test1");
	}//Test

	public static void main(String[] args) {

		try {
			new Test();
		} catch (ClassNotFoundException e) {
//		API�� ����e.printStackTrace();���� ����ϴ� ������ Console�� �ƴ� ���� ( c:/dev/err.log )�� ���
			e.printStackTrace();
			System.err.println(e);
		}//end catch
		
	}//main

}//class
