package com.itb.inf2dm.comercio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.inf2dm.comercio.model.Produto;


@Controller
@RequestMapping("/comercio/produtos")
public class LojaController {
	
	List<Produto> listaDeProdutos = new ArrayList<Produto>();
	
	@GetMapping("/listar")
	public String ListarProdutos(Model model) {
		
		/*Produto p1 = new Produto();
		p1.setId(20l);
		p1.setNome("Computador red dragon sei la oq");
		p1.setCodigoBarras("NSJAGGUIASG12313");
		p1.setPreco(3654.12);
		p1.setDescricao("COMPUTADOR PICHAU GAMER");
		p1.setStatus(true);
		
		
		Produto p2 = new Produto();
		p2.setId(20l);
		p2.setNome("PS4");
		p2.setCodigoBarras("BSABSAJJAISJ5689");
		p2.setPreco(2000.0);
		p2.setDescricao("Console de penúltima geração");
		p2.setStatus(false);
		
	   listaDeProdutos.add(p1);
	   listaDeProdutos.add(p2);
	   */
	   model.addAttribute("listaDeProdutos", listaDeProdutos);
	   
	   
	   return "Produtos";
	}
    
	@GetMapping("/novo-prod")
	public String novoProduto (Model model, Produto produto) {
		
		model.addAttribute("produto", produto);
		return "novo-prod";
	}
	
	@PostMapping("/add-prod")
	public String gravarNovoProduto(Model model, Produto produto) {
		
		listaDeProdutos.add(produto);
		return "redirect:/comercio/produtos/listar";
	}
}
