package kr.co.sist.di;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DependencyService {

	private DependencyDAO pDAO;//������ ���� ���� Ŭ����
	
	//@Autowired�� ���� ������ ���Թޱ����� �����ڰ� �ʿ����
	
	public List<String> searchList(){
		//������ ���Թ��� ��ü ���
		return pDAO.selectList();
	}//searchList
}
