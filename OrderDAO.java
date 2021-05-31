package Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.UserDBConnection;


/**
 * 주문에 대한 동작을 쿼리문으로 정의하는 클래스
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
		//1. Connection 얻기
			con = dc.getConn();
		//2. 쿼리문 생성객체 얻기
			String selectQuery="select ORDER_NUM, PROD_NUM, MEMBER_ID, ORDER_SIZE, ORDER_PRICE, ORDER_QUANTITY "
					+ "from ORDER_DETAILS where ORDER_NUM=? and MEMBER_ID=?";
			
			pstmt = con.prepareStatement( selectQuery );
		//3. 바인드변수에 값 할당
			pstmt.setInt(1, osVO.getOrder_num());
			pstmt.setString(2, osVO.getMember_id());
		//4. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//where절에 id와 비밀번호로 조회된 레코드가 있음. 로그인 성공
				odVO=new OrderDetailVO();
				odVO.setOrder_num(rs.getInt("ORDER_NUM"));
				odVO.setProd_num(rs.getInt("PROD_NUM"));
				odVO.setOrder_size(rs.getString("ORDER_SIZE"));
				odVO.setOrder_quantity(rs.getInt("ORDER_QUANTITY"));
				odVO.setProd_price(rs.getInt("ORDER_PRICE"));
			}//end if
		}finally {
		//5. 연결 끊기
			dc.dbClose(con, pstmt, rs);
		}//end finally
		return odVO;
	}//selectLogin
	
	
}//class
