package kr.co.sist.di;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DependencyService {

	private DependencyDAO pDAO;//의존성 주입 받을 클래스
	
	//@Autowired가 들어가면 의존성 주입받기위한 생성자가 필요없다
	
	public List<String> searchList(){
		//의존성 주입받은 객체 사용
		return pDAO.selectList();
	}//searchList
}
