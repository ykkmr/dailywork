package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.CpEmp1Domain;
import kr.co.sist.vo.CpEmp1VO;

public class ExamDAO {
	public int insertOne(int data) {
		int rowCnt=0;
		//MyBatis Handler얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		rowCnt = ss.insert("kr.co.sist.examMapper.insertOne",data);
		if(rowCnt ==1 ) {
			ss.commit();
		}//end if
		if(ss != null ){ss.close();} //end if
		return rowCnt;
	}//insertOne
	
	public int insertCpEmp1(CpEmp1VO ceVO) {
		int rowCnt=0;
		//MyBatis Handler얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		rowCnt = ss.insert("kr.co.sist.examMapper.insertCpEmp1",ceVO);
		if(rowCnt ==1 ) {
			ss.commit();
		}//end if
		if(ss != null ){ss.close();} //end if
		return rowCnt;
	}//insertCpEmp1
	
	public int updateCpEmp1(CpEmp1VO ceVO) {
		int rowCnt=0;
		//MyBatis Handler얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		rowCnt = ss.update("kr.co.sist.examMapper.updateCpEmp1",ceVO);
		if(rowCnt ==1 ) {
			ss.commit();
		}//end if
		if(ss != null ){ss.close();} //end if
		return rowCnt;
	}//updateCpEmp1
	
	public CpEmp1Domain selectCpEmp1() {
		//MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//select 작업 수행
		CpEmp1Domain ce1 = ss.selectOne("kr.co.sist.examMapper.selectData");
		
		if( ss != null ) { ss.close(); } //end if
		return ce1;
		
	}//selectCpEmp1
	
	public List<Integer> selectCpEmp2() {
		//MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//select 작업 수행
		List<Integer> list = ss.selectList("kr.co.sist.examMapper.selectCpEmp2");
		
		if( ss != null ) { ss.close(); } //end if
		return list;
		
	}//selectCpEmp2
	
	public int deleteCpEmp2(int empno) {
		int rowCnt=0;
		//MyBatis Handler얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//delete 작업 수행
		rowCnt = ss.update("kr.co.sist.examMapper.deleteCpEmp2",empno);
		if(rowCnt ==1 ) {
			ss.commit();
		}//end if
		if(ss != null ){ss.close();} //end if
		return rowCnt;
	}//updateCpEmp1
	
	
}
