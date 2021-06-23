package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.BoardDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.JoinDomain;
import kr.co.sist.service.SelectService;
import kr.co.sist.service.SelectService2;
import kr.co.sist.service.SelectService3;
import kr.co.sist.service.SelectService4;
import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.MgrVO;
import kr.co.sist.vo.ProcedureInsertVO;
import kr.co.sist.vo.TableVO;
import kr.co.sist.vo.boardVO;;

@Controller
public class SearchController4 {
	@RequestMapping(value="/select/procedure_insert.do", method= {GET,POST})
	public String useDynamicIf(ProcedureInsertVO piVO, Model model) {
		
		int cnt=0;
		
		if(piVO.getEname() != null ) { //입력값이 들어왔을 떄
			SelectService4 ss4 = new SelectService4();
			ss4.addProcedure(piVO);
			cnt=piVO.getRow_cnt();
		}//end if
		
		model.addAttribute("cnt", cnt);
		
		return "select4/proc_insert";
	}//useDynamicIf
	@RequestMapping(value="/select/procedure_select.do", method= {GET,POST})
	public String useProcedureSelect(@RequestParam(defaultValue = "") String dong, Model model) {
		
		int cnt=0;
		
		if(!"".equals(dong)) { //입력값이 들어왔을 떄
			SelectService4 ss4 = new SelectService4();
			model.addAttribute("zipcodeList",ss4.searchProcedure(dong));
		}//end if
		
		return "select4/proc_select";
	}//useDynamicIf
	
}
