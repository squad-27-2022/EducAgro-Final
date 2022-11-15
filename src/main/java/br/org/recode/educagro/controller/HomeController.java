package br.org.recode.educagro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping({"/","/home"})
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView dashboard(){
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping("/alfabetizacao")
	public ModelAndView alfabetizacao(){
		return new ModelAndView("alfabetizacao");
	}
	
	@RequestMapping("/educagro-dicaspais")
	public ModelAndView educagroDicasPais(){
		return new ModelAndView("educagro-dicaspais");
	}
	
	@RequestMapping("/educagro-dicasprof")
	public ModelAndView educagroDicasProf(){
		return new ModelAndView("educagro-dicasprof");
	}
	
	@RequestMapping("/matematica")
	public ModelAndView matematica(){
		return new ModelAndView("matematica");
	}
	
	@RequestMapping("/portugues")
	public ModelAndView portugues(){
		return new ModelAndView("portugues");
	}
	
	@RequestMapping("/sobre")
	public ModelAndView sobre(){
		return new ModelAndView("sobre");
	}
	
}
