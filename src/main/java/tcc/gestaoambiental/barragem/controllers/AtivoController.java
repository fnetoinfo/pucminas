package tcc.gestaoambiental.barragem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tcc.gestaoambiental.barragem.models.Ativo;
import tcc.gestaoambiental.barragem.repository.AtivoRepository;

@Controller				
public class AtivoController {

	@Autowired
	private AtivoRepository ativoRepository;

	@RequestMapping("/ativo/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ativo/listar");
		mv.addObject("itens", ativoRepository.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/ativo/cadastrar", method=RequestMethod.GET)
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("ativo/cadastro");
		mv.addObject("model", new Ativo());
		return mv;
	}
	
	@RequestMapping(value = "/ativo/cadastrar", method=RequestMethod.POST)
	public String cadastrar(Ativo ativo) {
		ativoRepository.save(ativo);
		
		return "redirect:/ativo/listar";
	}
	
	@RequestMapping(value = "/ativo/editar/{id}", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") long id) {
		Ativo ativo = ativoRepository.findById(id);

		ModelAndView mv = new ModelAndView("ativo/cadastro");
		mv.addObject("model", ativo);
		
		return mv;
	}
	
	@RequestMapping("/ativo/deletar/{id}")
	public String delete(@PathVariable("id") long id) {
		Ativo ativo = ativoRepository.findById(id);
		
		if (ativo != null) {
			ativoRepository.delete(ativo);
		}
		
		return "redirect:/ativo/listar";
	}
}