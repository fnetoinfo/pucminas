package tcc.gestaoambiental.barragem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller				
public class LoginController {

	@RequestMapping("/login")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/login/error")
	public ModelAndView error() {
		
		ModelAndView mv = new ModelAndView("login.html");
		mv.addObject("erro", "Usuário ou senha inválidos");
		
		return mv;
	}
}