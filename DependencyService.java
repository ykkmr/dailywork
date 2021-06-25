package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.DependencyDAO;
import kr.co.sist.domain.EmpDomain;

@Component
public class DependencyService {
	
	@Autowired(required = false)
	private DependencyDAO dDAO; //������ ���� �ޱ�
	
	public List<EmpDomain> searchEmpData(){
		//������ ���Թ��� ��ü ���
		List<EmpDomain> list = dDAO.selectMultiColumnMultiRow();
		
		return list;
	}
	
}//class
