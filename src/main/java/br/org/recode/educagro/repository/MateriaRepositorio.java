package br.org.recode.educagro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recode.educagro.entities.Materia;

public interface MateriaRepositorio extends JpaRepository<Materia, Long> {
    
}
