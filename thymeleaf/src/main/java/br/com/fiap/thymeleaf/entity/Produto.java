package br.com.fiap.thymeleaf.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="produto", sequenceName = "SQ_PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    private int codigo;
    private String nome;
    private double preco;
    private boolean novo;
    private LocalDate dataFabricacao;

    public Produto() {
        super();
    }
    public Produto(int codigo, String nome, double preco, boolean novo, LocalDate dataFabricacao) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.novo = novo;
        this.dataFabricacao = dataFabricacao;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public boolean isNovo() {
        return novo;
    }
    public void setNovo(boolean novo) {
        this.novo = novo;
    }
    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }
    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }


}