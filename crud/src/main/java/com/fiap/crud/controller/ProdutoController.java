package com.fiap.crud.controller;

import com.fiap.crud.entity.Produto;
import com.fiap.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    //CADASTRAR
    @GetMapping("cadastrar")
    public String abrirFormulario(Produto produto, Model model){
        model.addAttribute("prod", produto);
        return "produto/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid @ModelAttribute("prod") Produto produto, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()) {
            return "produto/form";
        }

        redirectAttributes.addFlashAttribute("msg","Cadastrado!");
        repository.save(produto);
        return "redirect:/produto/listar";
    }


    //LISTAR
    @GetMapping("listar")
    public String listarProdutos(Model model){
        model.addAttribute("produtos", repository.findAll());
        return "produto/lista";
    }


    //EDITAR
    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prod",repository.findById(codigo));
        return "produto/form";
    }


    //EXCLUIR
    @PostMapping("excluir")
    public String excluir(int codigo, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","Exterminado!");
        repository.deleteById(codigo);
        return "redirect:/produto/listar";
    }


    @GetMapping("home")
    public String home(){
        return "home";
    }
}
