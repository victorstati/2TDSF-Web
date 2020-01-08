package com.fiap.templates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByNome(String prod);

    //List<Produto> findByNomeAndPreco(String nome, double preco);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);

    List<Produto> findByPrecoOrderByNomeDesc(double preco);



}