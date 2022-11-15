package br.org.recode.educagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.recode.educagro.entities.Aluno;
import br.org.recode.educagro.entities.UF;
import br.org.recode.educagro.repository.AlunoRepositorio;

@Controller
@RequestMapping({"/alunos","/adm"})
public class AlunoControle {

    @Autowired
    private AlunoRepositorio alunoRepositorio;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("aluno/home");

        modelAndView.addObject("alunos", alunoRepositorio.findAll());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("aluno/detalhes");

        modelAndView.addObject("aluno", alunoRepositorio.getOne(id));

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("aluno/formulario");

        modelAndView.addObject("aluno", new Aluno());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("aluno/formulario");

        modelAndView.addObject("aluno", alunoRepositorio.getOne(id));
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Aluno aluno) {
        alunoRepositorio.save(aluno);

        return "redirect:/alunos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        alunoRepositorio.deleteById(id);

        return "redirect:/alunos";
    }
    
}
