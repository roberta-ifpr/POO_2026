package br.edu.ifpr.aula_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.ifpr.aula_jpa.model.Aluno;
import br.edu.ifpr.aula_jpa.repository.AlunoRepository;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Bean
    CommandLineRunner executar(AlunoRepository repo){
        return args -> {
            Aluno aluno = new Aluno("Fulano");
            repo.save(aluno);
            repo.findAll().forEach(a -> {
                System.out.println(a.getId()+ " "+ a.getNome());
            });
        };
    }

}
