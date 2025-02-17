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

import br.edu.unoesc.desafiofullstack.dto.ContatoDto;
import br.edu.unoesc.desafiofullstack.service.ContatoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

	@GetMapping("/listar/{pessoa}")
	public String listar(@PathVariable("pessoa") Long pessoa, Model model) {
	    List<ContatoDto> listaContatos = contatoService.encontrarPorPessoa(pessoa);
        model.addAttribute("pessoaCodigo", pessoa);
        model.addAttribute("contatos", listaContatos);
		
		return "contato/listagem";
	}	

    @GetMapping("/cadastro/{pessoa}")
    public String mostrarFormularioCadastro(@PathVariable("pessoa") Long pessoa, Model model) {
        model.addAttribute("pessoaCodigo", pessoa);
        model.addAttribute("contatoDto", new ContatoDto());
        return "contato/cadastro";
    }

    @PostMapping("/save/{pessoa}")
    public String novo(@Valid ContatoDto contatoDto, BindingResult result, @PathVariable("pessoa") Long pessoa, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
            return "contato/cadastro";
        }
        contatoService.salvar(contatoDto);
        return "redirect:/contato/listar/"+pessoa;
    }

    @GetMapping("/editar")
    public String editar(@RequestParam(name="id") Long codigo, @RequestParam(name="pessoa") Long pessoa, Model model){          
        ContatoDto contatoDto = contatoService.encontrarDtoPorId(codigo); 
        model.addAttribute("pessoaCodigo", pessoa);
        model.addAttribute("contatoDto", contatoDto);
        return "contato/cadastro";
    } 

    @GetMapping("/remover/{id}")
    public String deletar(@PathVariable("id") Long codigo, RedirectAttributes redirectAttributes){      
        contatoService.remover(codigo);
        return "redirect:/contato/listar/" + codigo;
    }            

}