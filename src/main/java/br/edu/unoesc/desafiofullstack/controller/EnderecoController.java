package br.edu.unoesc.desafiofullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	@GetMapping("/listar")
	public String listar() {
		return "endereco/listagem";
	}	

}