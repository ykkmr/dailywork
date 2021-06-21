package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.BoardDomain;
import kr.co.sist.domain.CpEmp1Domain;
import kr.co.sist.domain.DeptDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.JoinDomain;
import kr.co.sist.vo.CpEmp1VO;
import kr.co.sist.vo.TableVO;
import kr.co.sist.vo.boardVO;

public class SelectDAO2 {
	public SelectDAO2() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//SelectDAO
	
	public int selectTotalCount() {
		int cnt = 0;
			//1. MyBatis Handler ���
		SqlSession ss = MyBatisHandler.getInstance().getHandler();	
			//2. id�� �ش��ϴ� ������ ã�Ƽ� ������ �� ��� ���
		cnt=ss.selectOne("kr.co.sist.selectMapper2.selectTotalCount");
		if( ss != null ) { ss.close(); } //end if
		return cnt;
	}//selectTotalCount
	
	/**
	 * subquery
	 * @param bVO
	 * @return
	 */
	public List<BoardDomain> selectSubquery(boardVO bVO) {
		List<BoardDomain> list=null;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		list=ss.selectList("kr.co.sist.selectMapper2.selectTotalCount");
		if( ss != null ) { ss.close(); } //end if
		return list;
	}//selectSubquery
	
	public List<JoinDomain> selectJoin(){
		List<JoinDomain> list = null;
		
		//MyBatis Handler ���
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//�������� ����
		list=ss.selectList("kr.co.sist.selectMapper2.join");
		//Handler ���� ����
		if( ss != null ) { ss.close(); };
		
		return list;
	}//selectJoin
	
	public List<JoinDomain> selectSubqueryJoin(){
		List<JoinDomain> list = null;
		
		//MyBatis Handler ���
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//�������� ����
		list=ss.selectList("kr.co.sist.selectMapper2.subquery_join");
		//Handler ���� ����
		if( ss != null ) { ss.close(); }
		
		return list;
	}//selectSubqueryJoin
	
	public List<EmpDomain> selectDynamicTable(TableVO tVO){
		List<EmpDomain> list = null;
		
		//MyBatis Handler ���
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//�������� ����
		list=ss.selectList("kr.co.sist.selectMapper2.dynamicTab", tVO);
		//Handler ���� ����
		if( ss != null ) { ss.close(); }
		
		return list;
	}//selectDynamicTable

}//class
