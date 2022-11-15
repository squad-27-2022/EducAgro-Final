package br.org.recode.educagro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Materia extends Entidade {

    @Column(nullable = false, length = 40, unique = true)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
