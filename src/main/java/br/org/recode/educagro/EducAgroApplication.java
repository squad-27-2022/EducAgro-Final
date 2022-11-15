package br.org.recode.educagro;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.org.recode.educagro.entities.Endereco;
import br.org.recode.educagro.entities.Professor;
import br.org.recode.educagro.enums.UF;
import br.org.recode.educagro.repository.ProfessorRepositorio;
import br.org.recode.educagro.utils.SenhaUtils;

@SpringBootApplication
public class EducAgroApplication  implements CommandLineRunner{

	@Autowired
	// private ProfessorRepositorio professorRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(EducAgroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Configura um cadastro inicial para acessar a aplicação
	/*	Professor professor = new Professor();
		professor.setNome("admin");
		professor.setEmail("admin@educagro.org");
		professor.setSenha(SenhaUtils.encode("admin123"));
		professor.setDataNascimento(LocalDate.of(1990, 1, 1));
		professor.setTelefone("(11)91111-1111");
		professor.setCpf("111.111.111-11");
		
		Endereco endereco = new Endereco();
		endereco.setUf(br.org.recode.educagro.entities.UF.AM);
		endereco.setLogradouro("Rua Bahia");
		endereco.setCidade("Bahia");
		endereco.setBairro("Salvador");
		endereco.setNumero("100");
		endereco.setCep("00000-000");
		professor.setEndereco(endereco);
		
		professorRepositorio.save(professor); */
		
		
	}

}
