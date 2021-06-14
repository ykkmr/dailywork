package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.serviece.MainService;

@Controller
//@RequestMapping : �������� ��ûó�� �տ� �̸��� ����ؾ� �Ѵٸ�
public class MoveController2 {

	//View��������� �����͸� �ѹ��� �����ϴ� ��ü ModelAndView ��ȯ
	@RequestMapping(value="/day0614/use_mav.do", method = RequestMethod.GET)
	public ModelAndView useMav() {
		//ModelAndView ����
		ModelAndView mav = new ModelAndView();
		//view���������� ����
		mav.setViewName("day0614/use_mav");
		
		//Business Logic �����ϴ� Ŭ������ ��üȭ
		MainService ms = new MainService();
		
		//view���������� ����� �����ͳֱ�
		mav.addObject("img",ms.mainImgList());
		mav.addObject("notice",ms.noticeList());
		
		return mav;
	}//useMav
	
	@RequestMapping(value="/day0614/use_redirect.do", method = RequestMethod.GET)
	public String useRedirect() {
		
		//return "redirect:../day0611/call.jsp"; //�����
		return "redirect:http://localhost/spring_mvc/day0611/call.jsp"; //URL
	}//useRedirect
	
}
