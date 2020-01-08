package br.com.fiap.thymeleaf.controller;

import java.util.List;

import br.com.fiap.thymeleaf.entity.Produto;
import br.com.fiap.thymeleaf.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("{codigo}")
    public Produto buscar(@PathVariable int codigo){
        return produtoRepository.findById(codigo).get();
    }

    @GetMapping("/pesquisar")
    public List<Produto> buscarPorNome(@RequestParam(required = false) String nome) {
        if(nome != null) {
            return produtoRepository.findByNome(nome);
        }
        return produtoRepository.findAll();
    }

    @GetMapping("/pesquisar/preco")
    public List<Produto> buscarPorPreco(@RequestParam(required = false) double preco){
        return produtoRepository.findByPrecoOrderByNomeDesc(preco);
    }

    @GetMapping("/pesquisar/nome")
    public List<Produto> buscarPorNomeIgnoreCase(@RequestParam(required = false) String nome){
        if(nome != null) {
            return produtoRepository.findByNomeIgnoreCaseOrderByPrecoAsc(nome);
        }
        return produtoRepository.findAll();
    }

    @GetMapping("/pesquisar/novo")
    public List<Produto> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "false") Boolean novo){
        return nome!=null?
                produtoRepository.findByNomeAndNovo(nome,novo):
                produtoRepository.findByNovo(novo);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @PutMapping("{id}")
    public Produto atualizar(@RequestBody Produto produto,
                             @PathVariable int id){
        produto.setCodigo(id);
        return produtoRepository.save(produto);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        produtoRepository.deleteById(codigo);
    }



}
