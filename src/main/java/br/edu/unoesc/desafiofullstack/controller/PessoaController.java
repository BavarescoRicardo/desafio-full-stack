package br.edu.unoesc.desafiofullstack.controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.desafiofullstack.dto.PessoaDto;
import br.edu.unoesc.desafiofullstack.service.PessoaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
    @Autowired
    private PessoaService pessoaService;

	@GetMapping("/listar")
	public String listar(Model model) {
	    List<PessoaDto> listaPessoas = pessoaService.encontrar();
        model.addAttribute("pessoas", listaPessoas);
		
		return "pessoa/listagem";
	}	

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("pessoaDto", new PessoaDto());
        return "pessoa/cadastro";
    }

    @PostMapping("/save")
    public String novo(@Valid PessoaDto pessoaDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "pessoa/cadastro";
        }

        pessoaService.salvar(pessoaDto);
        return "redirect:/pessoa/listar";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long codigo, Model model){          
        PessoaDto pessoaDto = pessoaService.encontrarDtoPorId(codigo); 
        model.addAttribute("pessoa", pessoaDto);
        return "/pessoa/cadastro";
    } 

    @GetMapping("/remover/{id}")
    public String deletar(@PathVariable("id") Long codigo, RedirectAttributes redirectAttributes){      
        pessoaService.remover(codigo);
        return "redirect:/pessoa/listar";
    }        

}