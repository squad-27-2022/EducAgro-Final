package br.org.recode.educagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.recode.educagro.entities.Materia;
import br.org.recode.educagro.repository.MateriaRepositorio;

@Controller
@RequestMapping("/materias")
public class MateriaControle {

    @Autowired
    private MateriaRepositorio materiaRepositorio;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("materia/home");

        modelAndView.addObject("materias", materiaRepositorio.findAll());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("materia/formulario");

        modelAndView.addObject("materia", new Materia());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("materia/formulario");

        modelAndView.addObject("materia", materiaRepositorio.getOne(id));

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Materia materia) {
        materiaRepositorio.save(materia);

        return "redirect:/materias";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        materiaRepositorio.deleteById(id);

        return "redirect:/materias";
    }
    
}
