*쿼리문에 대한 작업만 정의
 * @author user
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatementDAO {
	
	/**
	 * cp_emp4 테이블에 VO의 값을 추가하는 일
	 * 추가성공 아니면 예외상황 둘 중 하나의 결과 도출
	 * @param eVO 사원번호, 사원명, 부서번호, 직무를 가진 VO
	 * @throws SQLException
	 */
	public void insertCpEmp4(EmpVO eVO) throws SQLException {
		
		//1. 드라이버로딩 (ojdbc8.jar)
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		//2. 커넥션 얻기
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id ="scott";
		String pass = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url,id,pass);
		
		//3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
		//4. 쿼리문 수행 후 결과 얻기
			String insertCpEmp=
			"insert into cp_emp4(empno, ename, deptno, job, hiredate)values("+eVO.getEmpno()+
			", '"+eVO.getEname()+"', "+ eVO.getDeptno()+", '"+eVO.getJob()+"', sysdate)";
			int cnt = stmt.executeUpdate(insertCpEmp);
			
			System.out.println(cnt + "건 추가");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 연결 끊기. 반드시 실행되어야하기 때문에 finally 블럭에서 구현
			if( stmt != null ) { stmt.close(); } //end if
			if( con != null ) { con.close(); } //end if
			
		}//end finally
		
	}//insertCpEmp4
	
	/**
	 * 사원번호, 사원명, 부서번호, 직무를 입력받아 사원번호에 해당하는 사원정보를 
	 * 변경하는 일
	 * @param eVO 변경할 사원정보
	 * @return 변경된 행의 수 
	 */
	public int updateCpEmp4(EmpVO eVO) {
		int cnt = 0;
		
		return cnt;
	}//updateCpEmp4

	public int deleteCpEmp4(int empno) {
		int cnt = 0;
		
		return cnt;
	}//deleteCpEmp4
	
	public List<EmpAllVO> selectAllCpEmp4(){
		List<EmpAllVO> list = new ArrayList<EmpAllVO>();
		
		return list;
	}//selectAllCpEmp4
	
	public EmpOneVO selectOneCpEmp4(int empno) {
		EmpOneVO eoVO = null;
		
		return eoVO;
	}//selectOneCpEmp4
	
	public static void main(String[] args) {
		StatementDAO s = new StatementDAO();
//		try {
//		s.insertCpEmp4(new EmpVO(1212,"테스트",10,"대리"));
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}//end catch
	}
	
}//class
