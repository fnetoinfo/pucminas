package tcc.gestaoambiental.barragem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tcc.gestaoambiental.barragem.repository.LocalRepository;

@Controller				
public class MonitoramentoController {

	@Autowired
	private LocalRepository localRepository;

	@RequestMapping("/monitoramento")
	public ModelAndView index() {
				
		ModelAndView mv = new ModelAndView("monitoramento/index");			
		mv.addObject("locais", localRepository.findAll());
		
		return mv;
	}
}