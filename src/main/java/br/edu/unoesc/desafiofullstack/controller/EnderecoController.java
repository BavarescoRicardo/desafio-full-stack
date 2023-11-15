package br.edu.unoesc.desafiofullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.desafiofullstack.dto.EnderecoDto;
import br.edu.unoesc.desafiofullstack.service.EnderecoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

	@GetMapping("/listar/{pessoa}")
	public String listar(@PathVariable("pessoa") Long pessoa, Model model) {
	    List<EnderecoDto> listaEnderecos = enderecoService.encontrarPorPessoa(pessoa);
        model.addAttribute("pessoaCodigo", pessoa);
        model.addAttribute("enderecos", listaEnderecos);
		
		return "endereco/listagem";
	}	
    @GetMapping("/cadastro/{pessoa}")
    public String cadastro(@PathVariable("pessoa") Long pessoa, Model model) {
        model.addAttribute("pessoaCodigo", pessoa);
        model.addAttribute("enderecoDto", new EnderecoDto());
        return "endereco/cadastro";
    }    

    @PostMapping("/save/{pessoa}")
    public String salvar(@Valid EnderecoDto enderecoDto, BindingResult result, @PathVariable("pessoa") Long pessoa, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "endereco/cadastro";
        }

        enderecoService.salvar(enderecoDto);
        return "redirect:/endereco/listar/"+pessoa;
    }

    @GetMapping("/editar")
    public String editar(@RequestParam(name="id") Long codigo, @RequestParam(name="pessoa") Long pessoa, Model model){          
        EnderecoDto enderecoDto = enderecoService.encontrarDtoPorId(codigo); 
        model.addAttribute("pessoaCodigo", pessoa);
        model.addAttribute("enderecoDto", enderecoDto);
        return "endereco/cadastro";
    } 

    @GetMapping("/remover/{id}")
    public String deletar(@PathVariable("id") Long codigo, RedirectAttributes redirectAttributes){      
        enderecoService.remover(codigo);
        return "redirect:/endereco/listar/" + codigo;
    }
}