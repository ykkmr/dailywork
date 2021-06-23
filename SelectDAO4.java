package kr.co.sist.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.BoardDomain;
import kr.co.sist.domain.CpEmp1Domain;
import kr.co.sist.domain.DeptDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.JoinDomain;
import kr.co.sist.domain.ZipcodeDomain;
import kr.co.sist.vo.CpEmp1VO;
import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.MgrVO;
import kr.co.sist.vo.ProcedureInsertVO;
import kr.co.sist.vo.TableVO;
import kr.co.sist.vo.UpdateVO;
import kr.co.sist.vo.boardVO;

public class SelectDAO4 {
	public SelectDAO4() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//SelectDAO4

	public void insertProc( ProcedureInsertVO piVO ) {
		//int cnt=0;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		ss.selectOne("kr.co.sist.selectMapper3.insertProc" , piVO); //piVO�� MyBatis�� ���޵Ǿ�
		//procedure�� ȣ���Ͽ� ������ ����� �����ϰ� �ȴ�
		
		//cnt=piVO.getRow_cnt(); //piVO�� �����ϴ� ���� �߰��ϰ�, �߰��� ����� ��ų� 
		
		if( ss != null ) { ss.close(); }//end if
	}//insertProc
	
	public List<ZipcodeDomain> selectProc(String dong){
		List<ZipcodeDomain> list = null;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("dong", dong); //�Էµ� ���� procedure�� ����
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		ss.selectOne("kr.co.sist.selectMapper3.proc_select",map);
		list=(List<ZipcodeDomain>)map.get("data");
		List<Map<String, Object>> selectList = (List<Map<String, Object>>)map.get("data");
		
		list=new ArrayList<ZipcodeDomain>();
		ZipcodeDomain zd = null;
		
		Map<String, Object> map1 = null;
		for(int i = 0 ; i < selectList.size() ; i ++) {
			map1 = selectList.get(i);
			
			zd= new ZipcodeDomain();
			zd.setZipcode((String)map.get("ZIPCODE"));
			zd.setZipcode((String)map.get("SIDO"));
			zd.setZipcode((String)map.get("GUGUN"));
			zd.setZipcode((String)map.get("DONG"));
			zd.setZipcode((String)map.get("BUNJI"));
			
			list.add(zd);
		}//end for
		return list;
	}//selectProc
	
	public static void main(String[] args) {
		SelectDAO4 s = new SelectDAO4();
		System.out.println(s.selectProc("����1��"));
	}//main
	
}//class
