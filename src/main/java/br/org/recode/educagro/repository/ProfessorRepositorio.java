package br.org.recode.educagro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recode.educagro.entities.Professor;

public interface ProfessorRepositorio extends JpaRepository<Professor, Long> {

    @EntityGraph(attributePaths = "endereco")
    List<Professor> findAll();
    
    Optional<Professor> findByEmail(String email);
}
