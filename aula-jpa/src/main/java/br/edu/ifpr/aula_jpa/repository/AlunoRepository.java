package br.edu.ifpr.aula_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpr.aula_jpa.model.Aluno;
//<classe de entidade, tipo PK>
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
