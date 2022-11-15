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
@RequestMapping("/voluntarios")
public class VoluntarioControle {

    @Autowired
    private AlunoRepositorio voluntarioRepositorio;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("voluntario/home");

        modelAndView.addObject("voluntarios", voluntarioRepositorio.findAll());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("voluntario/detalhes");

        modelAndView.addObject("voluntario", voluntarioRepositorio.getOne(id));

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("voluntario/formulario");

        modelAndView.addObject("voluntario", new Aluno());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("voluntario/formulario");

        modelAndView.addObject("voluntario", voluntarioRepositorio.getOne(id));
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Aluno voluntario) {
        voluntarioRepositorio.save(voluntario);

        return "redirect:/voluntarios";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        voluntarioRepositorio.deleteById(id);

        return "redirect:/voluntarios";
    }
    
}
