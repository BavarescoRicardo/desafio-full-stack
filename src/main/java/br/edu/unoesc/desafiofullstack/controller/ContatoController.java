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

	@GetMapping("/listar")
	public String listar(@RequestParam(name="codigo", required=false) long codigo, Model model) {
	    List<ContatoDto> listaContatos = null;
        model.addAttribute("contatos", listaContatos);
		
		return "contato/listagem";
	}	

    @GetMapping("/cadastro/{pessoa}")
    public String mostrarFormularioCadastro(@PathVariable("pessoa") Long pessoa, Model model) {
        model.addAttribute("pessoaCodigo", pessoa);
        model.addAttribute("contatoDto", new ContatoDto());
        return "contato/cadastro";
    }

    @PostMapping("/save")
    public String novo(@Valid ContatoDto contatoDto, BindingResult result, RedirectAttributes redirectAttributes) {
        System.out.println("Tentando salvar contato");
		if (result.hasErrors()) {
            return "contato/cadastro";
        }
        contatoService.salvar(contatoDto);
        return "redirect:/";
    }

}