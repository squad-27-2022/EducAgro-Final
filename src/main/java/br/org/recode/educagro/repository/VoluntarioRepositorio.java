package br.org.recode.educagro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recode.educagro.entities.Voluntario;

public interface VoluntarioRepositorio extends JpaRepository<Voluntario, Long> {

    @EntityGraph(attributePaths = "endereco")
    List<Voluntario> findAll();
    
}
