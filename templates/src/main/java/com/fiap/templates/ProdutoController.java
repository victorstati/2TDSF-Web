package com.fiap.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("cadastrar")
    public String cadastrar() {
        return "form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Produto produto, Model model) {
        model.addAttribute("prod", produto);
        repository.save(produto);
        return "sucesso";
    }
    //Pesquisa por nome
    @GetMapping("pesquisar1")
    public String abrirForm1()
    {
        return "pesquisa1";
    }

    @GetMapping("pesquisar1")
    public String processarForm(String nome, Model model){
        List<Produto> produtos = repository.findByNome(nome);
        model.addAttribute("prod", produtos);
        return "sucesso";
    }
    //Pesquisa por preço maior
    @GetMapping("pesquisar2")
    public String abrirForm2(){
        return "pesquisa2";
    }

    @GetMapping("pesquisar2")
    public String processarForm2(double preco, Model model){
        List<Produto> produtos = repository.findByPrecoGreaterThan(preco);
        model.addAttribute("prod", produtos);
        return "sucesso";
    }
    //Pesquisa por preço ordenado por nome
    @GetMapping("pesquisar3")
    public String abrirForm3(){
        return "pesquisa3";
    }

    @GetMapping("pesquisar3")
    public String processarForm3(double preco, Model model){
        List<Produto> produtos = repository.findByPrecoOrderByNomeDesc(preco);
        model.addAttribute("prod", produtos);
        return "sucesso";
    }

    //Pesquisa por Nome ordenado por preço
    @GetMapping("pesquisar4")
    public String abrirForm4(){
        return "pesquisa4";
    }

    @GetMapping("pesquisar4")
    public String processarForm4(String nome, Model model){
        List<Produto> produtos = repository.findByNomeIgnoreCaseOrderByPrecoAsc(nome);
        model.addAttribute("prod", produtos);
        return "sucesso";
    }

    @GetMapping("buscar")
    public String buscar() {
        return "busca";
    }

    @PostMapping("buscar")
    public String buscar(int codigo, Model model) {
        Optional<Produto> produto = repository.findById(codigo);
        model.addAttribute("prod", produto);
        return "resultado";
    }
}
