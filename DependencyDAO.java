package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.EmpDomain;

@Component
public class DependencyDAO {
	public DependencyDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	public List<EmpDomain> selectMultiColumnMultiRow() {
		List<EmpDomain> list= null;
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();	
		//2. id에 해당하는 쿼리를 찾아서 실행한 후 결과 얻기
		list =ss.selectList("kr.co.sist.selectMapper.multiColumnMultiRow");
		if( ss != null ) { ss.close(); } //end if
		return list;
	}//selectSingleColumnMultiRow
}
