package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.service.ExamService;
import kr.co.sist.vo.CpEmp1VO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;;
@Controller
public class DmlController {
	@RequestMapping(value="/insert/one_value.do",method= GET)
	public String insertOneValue(@RequestParam(defaultValue = "0")int data,Model model) {
		
		ExamService es = new ExamService();
		model.addAttribute("cnt", es.addCpEmp1(data));
		System.out.println(data);
		return "insert/insert_one_value";
	}//insertOneValue
	
	@RequestMapping(value="/insert/cp_emp_add.do",method= POST)
	public String addCpEmp1(CpEmp1VO ceVO,Model model) {
		
		ExamService es = new ExamService();
		model.addAttribute("cnt", es.addCpEmp1AllColumn(ceVO));
		return "insert/cp_emp_result";
	}//addCpEmp1
	
	@RequestMapping(value="/update/cp_emp_modify.do",method= POST)
	public String modifyCpEmp1(CpEmp1VO ceVO,Model model) {
		
		ExamService es = new ExamService();
		model.addAttribute("cnt", es.modifyCpEmp1(ceVO));
		return "update/cp_emp_result";
	}//modifyCpEmp1
	
	@RequestMapping(value="/remove/remove_cp_emp.do",method= GET)
	public String modifyCpEmp2(int empno,Model model) {
		
		ExamService es = new ExamService();
		model.addAttribute("cnt", es.removeCpEmp2( empno ));
		return "remove/cp_emp_result";
	}//modifyCpEmp1
	
}
