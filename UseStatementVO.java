package day0407;

import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *	DBMS업무처리를 하는 DAO클래스를 사용하는 클래스로 업무로직을 정의하는 일을 주로 
 * 하는 클래스. 클래스명은 주로 Service 또는 Process가 붙어서 만들어진다
 * @author user
 */
public class UseStatementDAO {

	private StatementDAO sDAO;
	
	public UseStatementDAO() {
		sDAO = new StatementDAO();
	}//UseStatementDAO
	
	private void addCpEmp() {
		EmpVO eVO = new EmpVO(431, "조영래", 10, "과장");
		
		try {
			sDAO.insertCpEmp4(eVO);//method가 예외를 발생시키지 않으면 정상실행
			JOptionPane.showMessageDialog(null, eVO.getEmpno()+"번 사원정보가 추가되었습니다");
			
		} catch (SQLException se) {
			se.printStackTrace();
//			System.out.println(se.getErrorCode()+"/"+se.getMessage()+"/"+se.getSQLState());
			String errMsg ="";
			if(se.getErrorCode() == 1) {
				errMsg = "사원번호 또는 부서번호가 초과된 부분. 사원번호 4자리, 부서번호 2자리";
			}//end if
			if(se.getErrorCode() == 12899) {
				errMsg = "사원번호 또는 직무가 초과된 부분. 사원명 한글 3자 또는 영문 10자, 직무 한글 3자 영문 9자";
			}//end if	
			JOptionPane.showMessageDialog(null, errMsg);
		}//end catch
	}//addCpEmp
	
	private void modifyCpEmp() {
		
	}//modifyCpEmp
	
	private void removeCpEmp() {
		
	}//removeCpEmp
	
	private void searchAllCpEmp() {
		
	}//searchAllCpEmp
	
	private void searchOneCpEmp() {
		
	}//searchOneCpEmp
	
	public static void main(String[] args) {
		UseStatementDAO usDAO = new UseStatementDAO();
		usDAO.addCpEmp();
	}//main

}//class
