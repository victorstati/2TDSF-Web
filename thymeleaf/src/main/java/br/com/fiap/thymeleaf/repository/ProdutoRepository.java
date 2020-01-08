package br.com.fiap.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.thymeleaf.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    List<Produto> findByNome(String nome);

    List<Produto> findByNomeAndNovo(String nome, boolean novo);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByDataFabricacaoBetween(LocalDate i, LocalDate f);

    List<Produto> findByPrecoOrderByNomeDesc(double preco);

    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);

    List<Produto> findByNovo(Boolean novo);
}
