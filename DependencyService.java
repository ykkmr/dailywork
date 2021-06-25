package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.DependencyDAO;
import kr.co.sist.domain.EmpDomain;

@Component
public class DependencyService {
	
	@Autowired(required = false)
	private DependencyDAO dDAO; //의존성 주입 받기
	
	public List<EmpDomain> searchEmpData(){
		//의존성 주입받은 객체 사용
		List<EmpDomain> list = dDAO.selectMultiColumnMultiRow();
		
		return list;
	}
	
}//class
