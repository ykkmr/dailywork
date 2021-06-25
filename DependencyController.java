package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.service.DependencyService;

@Controller
public class DependencyController {
	
	@Autowired(required = false)
	private DependencyService ds; //Service 객체를 의존성 주입 받는다
	
	@RequestMapping(value="/autowired/select_autowired.do",method = RequestMethod.GET)
	public String useDepency(Model model) {
		model.addAttribute("empData",ds.searchEmpData());
		return "autowired/select_autowired";
	}
}
