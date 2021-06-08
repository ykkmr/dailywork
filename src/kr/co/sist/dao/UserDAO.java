package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.vo.WebMemberVO;

/**
 * 	���̵� �ߺ�Ȯ��, ȸ������
 * @author user
 */
public class UserDAO {
	/**
	 * id �ߺ�Ȯ��
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectId(String id)throws SQLException{
		String name="";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConnection db = DbConnection.getInstance();
		try {
			con=db.getConn();
			String selectId="select name from web_member where id=?";
			pstmt=con.prepareStatement(selectId);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				name=rs.getString("name");
			}//end if
			
		}finally {
			db.dbClose(con, pstmt, rs);
		}//end finally
		
		return name;
	}//selectId
	
	public void insertMember(WebMemberVO wmVO)throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DbConnection db = DbConnection.getInstance();
		
		try {
			
			con=db.getConn();
			
			String insertWebMember = 
					"insert into web_member(id,pass,email,name,birth,phone)values(?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(insertWebMember);
			pstmt.setString(1, wmVO.getId());
			pstmt.setString(2, wmVO.getPass());
			pstmt.setString(3, wmVO.getEmail());
			pstmt.setString(4, wmVO.getName());
			pstmt.setString(5, wmVO.getBirth());
			pstmt.setString(6, wmVO.getPhone());
			
			pstmt.executeUpdate();
		}finally {
			db.dbClose(con, pstmt, null);
		}//end finally
		
	}//insertMember
}//class
