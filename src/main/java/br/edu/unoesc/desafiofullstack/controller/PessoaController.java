package br.edu.unoesc.desafiofullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.desafiofullstack.dto.PessoaDto;
import br.edu.unoesc.desafiofullstack.service.PessoaService;
import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
    @Autowired
    private PessoaService pessoaService;    		

//	@GetMapping("/listar")
//	public String listar(Model model) {
//	    List<PessoaDto> listaPerfils = pessoaService.encontrar();
//
//	     model.addAttribute("listaPerfils", listaPerfils);		
//		
//		return "pessoa/listagem";
//	}	
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "pessoa/cadastro";
	}		

}