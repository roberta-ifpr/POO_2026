package br.edu.ifpr.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpr.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{

}
