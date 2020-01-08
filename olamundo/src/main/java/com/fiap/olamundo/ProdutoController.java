package com.fiap.olamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("cadastrar")
    public String abrirFormulario(){
        return "produto/form";
    }

    @PostMapping("cadastrar")
    public String processarForm(Produto produto, Model model){
        model.addAttribute("prod",produto);
        return "produto/sucesso";
    }
}
