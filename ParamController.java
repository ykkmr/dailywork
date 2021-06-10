package kr.co.sist.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ParamController {

	@RequestMapping(value="/use_request.do",method=RequestMethod.GET)
	public String requestForm() {
		return "use_request_form";
	}//requestForm
	
	@RequestMapping(value="/request_process.do",method=RequestMethod.GET)
	public String requestProcess(HttpServletRequest request, Model model) {
		//HttpServletRequest를 사용하여 web parameter 값 받기
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] lang = request.getParameterValues("lang");
		
		System.out.println( name + "/" + age + " " + Arrays.toString(lang));
		model.addAttribute("lang",lang); //request.setAttribute과 동일
		
		return "request_process";
	}//requestProcess
	
}
