package kr.co.sist.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 *	������ ������ Ŭ����
 * @author user
 */
@Component
public class DependencyDAO {

	public List<String> selectList(){
		List<String> list = new ArrayList<String>();
			list.add("������");
			list.add("�ݿ���");
			list.add("�Դϴ�");
			list.add("���� �� 29���� ���Ḧ �ϴ� �� �Դϴ�");
			list.add("�׵��� ��� �����̽��ϴ� ������");
		return list;
	}//selectList
}
