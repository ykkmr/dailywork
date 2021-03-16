package day0315;

public class Test {
	
	public Test() throws ClassNotFoundException{
		Class.forName("day0315.Test1");
	}//Test

	public static void main(String[] args) {

		try {
			new Test();
		} catch (ClassNotFoundException e) {
//		API를 보고e.printStackTrace();에서 출력하는 내용을 Console이 아닌 파일 ( c:/dev/err.log )로 출력
			e.printStackTrace();
			System.err.println(e);
		}//end catch
		
	}//main

}//class
