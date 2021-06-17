package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.domain.EmpDomain;
import kr.co.sist.vo.CpEmp1VO;

public class TestMyBatisDAO {

	public static void main(String[] args) {

		//1. ���� XML�� ����
		try {
			Reader reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis-config.xml");
		//2. MyBatis Framework ����
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//3. MyBatis Handler ���
			SqlSession ss = ssf.openSession();
		//4. MyBatis Handler�� ����� ������ ����
//			CpEmp1VO ce = new CpEmp1VO(11, 10, 3000, "������", "���");
//			int cnt = ss.insert("insertCpEmp1", ce);
//			
//			if( cnt == 1 ) {
//				ss.commit(); //transaction�� �Ϸ�
//			}
//			System.out.println( cnt + "�� �߰�");
			List<EmpDomain> list = ss.selectList("kr.co.sist.examMapper.selectEmp",30);
			if( list.isEmpty() ) {
				System.out.println("�μ��� �������� �ʰų�, �μ��� ����� �����ϴ�");
			}
			for(EmpDomain ed : list) {
				System.out.println(ed.getEmpno() + " / " + ed.getEname()+ " / " +  
							ed.getJob() + " / " + ed.getSal()+ " / " + ed.getHiredate());
			}
			
			//MyBatis Handler ����� ���� �Ǿ��ٸ� ���� �ش�
			if( ss != null ) { ss.close(); }//end if
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//main

}//class
