package kr.co.sist.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.BoardDomain;
import kr.co.sist.domain.CpEmp1Domain;
import kr.co.sist.domain.DeptDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.JoinDomain;
import kr.co.sist.vo.CpEmp1VO;
import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.MgrVO;
import kr.co.sist.vo.TableVO;
import kr.co.sist.vo.UpdateVO;
import kr.co.sist.vo.boardVO;

public class SelectDAO3 {
	public SelectDAO3() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//SelectDAO3

	public List<EmpDomain> selectDynamicIf(MgrVO mVO){
		List<EmpDomain> list = null;
		
		//1. MyBatis Handler 얻기
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		//2. 쿼리문 수행 값 받기
		list=ss.selectList("kr.co.sist.selectMapper2.dynamic_if",mVO);
		//3. Handler 종료
		if( ss != null ) { ss.close(); }//end if
		return list;
	}//selectDynamicIf
	
	public List<EmpDomain> selectDynamicChoose(DeptVO dVO){
		List<EmpDomain> list = null;
		
		//1. MyBatis Handler 얻기
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		//2. 쿼리문 수행 값 받기
		list=ss.selectList("kr.co.sist.selectMapper2.dynamic_choose",dVO);
		//3. Handler 종료
		if( ss != null ) { ss.close(); }//end if
		return list;
	}//selectDynamicChoose
	
	public List<String> selectDynamicTrim(int flag){//MySql Parameter 값이 하나라면
		//getter method가 없는 단일형(기본형,String) 또는 VO 모두 사용 가능하다
		List<String> list = null;
		
		//1. MyBatis Handler 얻기
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		//2. 쿼리문 수행 값 받기
		list=ss.selectList("kr.co.sist.selectMapper2.dynamic_trim",flag);
		//3. Handler 종료
		if( ss != null ) { ss.close(); }//end if
		return list;
	}//selectDynamicChoose
	
	public int updateDynamic( UpdateVO uVO ) {
		int cnt=0;
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		cnt = ss.update("kr.co.sist.selectMapper2.dynamic_trim2", uVO);
				
		if( ss != null ) { ss.close(); } //end if
		return cnt;
	}//updateDynamic
	
	public List<EmpDomain> selectDynamicForeach(int[] deptArr){
		List<EmpDomain> list = null;
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		
		list = ss.selectList("kr.co.sist.selectMapper2.dynamic_foreach_array", deptArr);
		
		if( ss != null ) { ss.close(); } //end if
		return list;
	}//selectDynamicForeach
	
	public List<EmpDomain> selectDynamicForeach(List<Integer> listParam){
		List<EmpDomain> list = null;
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		
		list = ss.selectList("kr.co.sist.selectMapper2.dynamic_foreach_list", listParam);
		
		if( ss != null ) { ss.close(); } //end if
		return list;
	}//selectDynamicForeach
	
	public static void main(String[] a) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		SelectDAO3 s = new SelectDAO3();
		System.out.println(s.selectDynamicForeach(list));
	}
	
}//class
