package kr.co.sist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"name","age"}) //���ǿ� �Ҵ��� ���� n���� ��� �迭�� ���
public class SessionController {

	@RequestMapping(value="/day0614/use_session_a.do", method= RequestMethod.GET)
	public String useSession(Model model) {
		
		model.addAttribute("name","�ѻ��"); //request,session => ���� ��� ���������� ��밡��
		model.addAttribute("nick","thumb"); //request => ���� forward�̵��� ���� ������������ ��밡��
		model.addAttribute("age",20); //request,session => ���� ��� ���������� ��밡��
		
		return "day0614/use_session_a";
	}//useSession

	@RequestMapping(value="/day0614/use_session_b.do", method= RequestMethod.GET)
	public String useSessionB(HttpSession session) {
		//Controller���� ������ ���� ���� ������ �Ű������� HttpSession�� �����Ѵ�
		System.out.println("name="+session.getAttribute("name")+", age = "
		+session.getAttribute("age"));
		return "day0614/use_session_b";
	}//useSession

	@RequestMapping(value="/day0614/use_session_c.do", method= RequestMethod.GET)
	public String useSessionC( SessionStatus ss) {
		//���� ����� �Ϸ�Ǿ��ٸ�(�α׾ƿ� �� ��Ȳ)
		ss.setComplete();
		System.out.println("���� ����� ����Ǿ��°�?"+ss.isComplete());
		
		return "day0614/use_session_c";
	}//useSession
}
