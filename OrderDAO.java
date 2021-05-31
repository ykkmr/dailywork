package Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.UserDBConnection;


/**
 * �ֹ��� ���� ������ ���������� �����ϴ� Ŭ����
 * @author sist
 */
public class OrderDAO {
	public OrderDetailVO selectOrder(OrderSimpleVO osVO)throws SQLException{
		OrderDetailVO odVO = null;
		
		UserDBConnection dc= UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1. Connection ���
			con = dc.getConn();
		//2. ������ ������ü ���
			String selectQuery="select ORDER_NUM, PROD_NUM, MEMBER_ID, ORDER_SIZE, ORDER_PRICE, ORDER_QUANTITY "
					+ "from ORDER_DETAILS where ORDER_NUM=? and MEMBER_ID=?";
			
			pstmt = con.prepareStatement( selectQuery );
		//3. ���ε庯���� �� �Ҵ�
			pstmt.setInt(1, osVO.getOrder_num());
			pstmt.setString(2, osVO.getMember_id());
		//4. ������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//where���� id�� ��й�ȣ�� ��ȸ�� ���ڵ尡 ����. �α��� ����
				odVO=new OrderDetailVO();
				odVO.setOrder_num(rs.getInt("ORDER_NUM"));
				odVO.setProd_num(rs.getInt("PROD_NUM"));
				odVO.setOrder_size(rs.getString("ORDER_SIZE"));
				odVO.setOrder_quantity(rs.getInt("ORDER_QUANTITY"));
				odVO.setProd_price(rs.getInt("ORDER_PRICE"));
			}//end if
		}finally {
		//5. ���� ����
			dc.dbClose(con, pstmt, rs);
		}//end finally
		return odVO;
	}//selectLogin
	
	
}//class
