package br.edu.unoesc.desafiofullstack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstack.dto.ContatoDto;
import br.edu.unoesc.desafiofullstack.model.Contato;
import br.edu.unoesc.desafiofullstack.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoDB;
    private final PessoaService pessoaService;


    public Optional<Contato> encontrarPorId(Long id){        
        return contatoDB.findById(id);
    }

    public ContatoDto encontrarDtoPorId(Long id){        
        Contato contato = contatoDB.findById(id).get();
        ContatoDto contatoDto = new ContatoDto(
        		contato.getCodigo(), contato.getEmail(), contato.getTelefone(), contato.getPessoa().getCodigo());
        return contatoDto;
    }    

    public List<ContatoDto> encontrar(){
        List<ContatoDto> listaDto = new ArrayList<ContatoDto>();
        
        // Converte a lista de objetos da entidade em objetos dto para transferencia
        for(Contato contato: contatoDB.findAll()) {
            listaDto.add(new ContatoDto(
        		contato.getCodigo(), contato.getEmail(), contato.getTelefone(), contato.getPessoa().getCodigo()));
        }

        return listaDto;
    }

   public boolean salvar(ContatoDto contatoDto){
       try {
            Contato contato = null;
            if (contatoDto.getCodigo() != null) {
                contato = new Contato(
                        contatoDto.getCodigo(), contatoDto.getEmail(), contatoDto.getTelefone(), 
                        pessoaService.encontrarPorId(Long.valueOf(contatoDto.getPessoa())));                    
            }else {
                contato = new Contato(
                        contatoDto.getEmail(), contatoDto.getTelefone(), pessoaService.encontrarPorId(Long.valueOf(contatoDto.getPessoa())));                                    
            }

       	contatoDB.save(contato);
        return true;
       } catch (Exception e) {
           return false;
       }
   } 

    public List<ContatoDto> encontrarPorPessoa(Long pessoa){
        List<ContatoDto> listaDto = new ArrayList<ContatoDto>();
        
        // Converte a lista de objetos da entidade em objetos dto para transferencia
        for(Contato contato: contatoDB.encontrarPorCodigoPessoa(pessoa)) {
            listaDto.add(new ContatoDto(
        		contato.getCodigo(), contato.getEmail(), contato.getTelefone(), contato.getPessoa().getCodigo()));
        }

        return listaDto;
    } 

   public ResponseEntity<String> remover(long id){
       try {
            Contato contato = encontrarPorId(id).get();
            contatoDB.delete(contato);
           return ResponseEntity.ok().body("Removido objeto de id: "+id);
       } catch (Exception e) {
           return ResponseEntity.notFound().build();
       }
   }  
}
