package br.org.recode.educagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.recode.educagro.entities.Professor;
import br.org.recode.educagro.entities.UF;
import br.org.recode.educagro.repository.ProfessorRepositorio;
import br.org.recode.educagro.utils.SenhaUtils;

@Controller
@RequestMapping("/professores")
public class ProfessorControle {

	@Autowired
	private ProfessorRepositorio professorRepositorio;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("professor/home");

		modelAndView.addObject("professores", professorRepositorio.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("professor/detalhes");

		modelAndView.addObject("professor", professorRepositorio.getOne(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("professor/formulario");

		modelAndView.addObject("professor", new Professor());
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("professor/formulario");

		modelAndView.addObject("professor", professorRepositorio.getOne(id));
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar"})
	public String salvar(Professor professor) {
		String senhaEncriptada = SenhaUtils.encode(professor.getSenha());
		professor.setSenha(senhaEncriptada);
		professorRepositorio.save(professor);
		return "redirect:/professores";
	}
	
	 @PostMapping("/{id}/editar")
	    public String editar(Professor professor, @PathVariable Long id) {
	        String senhaAtual = professorRepositorio.getOne(id).getSenha();
	        professor.setSenha(senhaAtual);

	        professorRepositorio.save(professor);

	        return "redirect:/professores";
	    }

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		professorRepositorio.deleteById(id);

		return "redirect:/professores";
	}
	@GetMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView modelAndView = new ModelAndView("professor/cadastro");

		modelAndView.addObject("professor", new Professor());
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}
	@PostMapping({ "/cadastro"})
	public String criar(Professor professor) {
		String senhaEncriptada = SenhaUtils.encode(professor.getSenha());
		professor.setSenha(senhaEncriptada);
		professorRepositorio.save(professor);
		return "redirect:/dashboard";
	}
	
}
