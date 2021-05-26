package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.vo.InterestVO;

/**
 * �Է°��� �޾� DB�� �߰�
 * @author user
 *
 */
public class SummerNoteDAO {
	/**
	 * 	�̸��� ���ɻ�(��������) table �߰�
	 * @throws SQLException
	 */
	public void insertFile( InterestVO iVO )throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dc = DbConnection.getInstance();
		try {
		//1. JNDI��밴ü ����
		//2. DBCP���� DB���ᰴü ���
		//3. DB���� ��ü���� Connection ���
			con=dc.getConn();
		//4. ������ ������ü ���
			String insertFile = "insert into test_file(num,name,text2)values(seq_file.nextval,?,?)";
			pstmt=con.prepareStatement(insertFile);
		//varchar2�� clob�� insert�� ������ setString()�� ó���Ѵ�
		//5. ���ε� ������ �� ����
			pstmt.setString(1, iVO.getName());
			pstmt.setString(2, iVO.getInterest());//clob
		//6. ������ ����
			pstmt.executeUpdate();
		}finally {
		//7. ���� ����
			dc.dbClose(con, pstmt, null);
		}//end finally
	}//insertFile
	
	public InterestVO selectFile( int num )throws SQLException{
		InterestVO iVO = null;
		//1. JNDI��밴ü ����
		//2. DBCP���� DB���ᰴü ���
		//3. DB���� ��ü���� Connection ���
		//4. ������ ������ü ���
		//5. ���ε� ������ �� ����
		//6. ������ ����
		//7. ���� ����
		return iVO;
	}//selectFile
	
}//class
