package com.fiap.crud.repository;

import com.fiap.crud.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {

    List<Produto> findByNome(String nome);

    List<Produto> findByNomeAndPreco(String nome, double preco);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByPrecoOrderByNomeDesc(double preco);

    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);
}