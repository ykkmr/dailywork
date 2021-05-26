package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.vo.InterestVO;

/**
 * 입력값을 받아 DB에 추가
 * @author user
 *
 */
public class SummerNoteDAO {
	/**
	 * 	이름과 관심사(파일포함) table 추가
	 * @throws SQLException
	 */
	public void insertFile( InterestVO iVO )throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dc = DbConnection.getInstance();
		try {
		//1. JNDI사용객체 생성
		//2. DBCP에서 DB연결객체 얻기
		//3. DB연결 객체에서 Connection 얻기
			con=dc.getConn();
		//4. 쿼리문 생성객체 얻기
			String insertFile = "insert into test_file(num,name,text2)values(seq_file.nextval,?,?)";
			pstmt=con.prepareStatement(insertFile);
		//varchar2나 clob를 insert할 때에는 setString()로 처리한다
		//5. 바인드 변수에 값 설정
			pstmt.setString(1, iVO.getName());
			pstmt.setString(2, iVO.getInterest());//clob
		//6. 쿼리문 수행
			pstmt.executeUpdate();
		}finally {
		//7. 연결 끊기
			dc.dbClose(con, pstmt, null);
		}//end finally
	}//insertFile
	
	public InterestVO selectFile( int num )throws SQLException{
		InterestVO iVO = null;
		//1. JNDI사용객체 생성
		//2. DBCP에서 DB연결객체 얻기
		//3. DB연결 객체에서 Connection 얻기
		//4. 쿼리문 생성객체 얻기
		//5. 바인드 변수에 값 설정
		//6. 쿼리문 수행
		//7. 연결 끊기
		return iVO;
	}//selectFile
	
}//class
