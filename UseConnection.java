package day0406;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class UseConnection {

	public UseConnection() {
		//1. Driver 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//2. 로딩된 드라이버를 사용하여 Connection 얻기
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id ="scott";
		String pass="tiger";
		
		try {
			// 외부 Driver(배포된 jar)를 Eclipse에서 인식하도록 만들려면 build path를 설정해야한다
			// 외부 Driver(배포된 jar)를 실행중인 JDK에서 인식하도록 만들려면 classpath를 설정해야한다
			
			Connection con = DriverManager.getConnection(url, id, pass);
			System.out.println("드라이버 로딩 성공"+con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//UseConnection
	
	public static void main(String[] args) {
		new UseConnection();
	}//main

}//class
