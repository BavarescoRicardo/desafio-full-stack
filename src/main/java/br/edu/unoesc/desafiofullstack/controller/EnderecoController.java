package br.edu.unoesc.desafiofullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.desafiofullstack.dto.EnderecoDto;
import br.edu.unoesc.desafiofullstack.dto.PessoaDto;
import br.edu.unoesc.desafiofullstack.service.PessoaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private PessoaService pessoaService;

	@GetMapping("/listar")
	public String listar(Model model) {
	    List<EnderecoDto> listaPessoas = null;
        model.addAttribute("enderecos", listaPessoas);
		
		return "endereco/listagem";
	}	

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("enderecoDto", new EnderecoDto());
        return "endereco/cadastro";
    }

    @PostMapping("/save")
    public String novo(@Valid PessoaDto pessoaDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "endereco/cadastro";
        }

        // boolean salvouComSucesso = pessoaService.salvar(pessoaDto);
        pessoaService.salvar(pessoaDto);
        return "redirect:/";
    }
}