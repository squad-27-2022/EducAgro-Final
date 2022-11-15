package br.org.recode.educagro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recode.educagro.entities.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

    @EntityGraph(attributePaths = "endereco")
    List<Aluno> findAll();
    
}
