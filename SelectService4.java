package kr.co.sist.service;

import java.util.List;

import kr.co.sist.dao.SelectDAO2;
import kr.co.sist.dao.SelectDAO3;
import kr.co.sist.dao.SelectDAO4;
import kr.co.sist.domain.BoardDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.JoinDomain;
import kr.co.sist.domain.ZipcodeDomain;
import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.MgrVO;
import kr.co.sist.vo.ProcedureInsertVO;
import kr.co.sist.vo.TableVO;
import kr.co.sist.vo.boardVO;

public class SelectService4 {
		
	public void addProcedure(ProcedureInsertVO piVO) {
		SelectDAO4 sd4 = new SelectDAO4();
		sd4.insertProc(piVO); //piVO객체는 하나이므로 입력된 객체에 값이 설정된다
	}//addProcedure
	
	public List<ZipcodeDomain> searchProcedure(String dong){
		List<ZipcodeDomain> list = null;
		SelectDAO4 sd4 = new SelectDAO4();
		list=sd4.selectProc(dong);
		return list;
	}
}//class
