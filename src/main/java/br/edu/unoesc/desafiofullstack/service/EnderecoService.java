package br.edu.unoesc.desafiofullstack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstack.dto.EnderecoDto;
import br.edu.unoesc.desafiofullstack.model.Endereco;
import br.edu.unoesc.desafiofullstack.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoDB;
    private final PessoaService pessoaService;


    public Optional<Endereco> encontrarPorId(Long id){        
        return enderecoDB.findById(id);
    }

    public EnderecoDto encontrarDtoPorId(Long id){        
        Endereco endereco = enderecoDB.findById(id).get();
        EnderecoDto enderecoDto = new EnderecoDto(
            endereco.getCodigo(), endereco.getCep(), endereco.getLogradouro(),
            endereco.getNumero(), endereco.getBairro(), 
            endereco.getMunicipio(), endereco.getEstado(), endereco.getPessoa().getCodigo());
        return enderecoDto;
    }    

    public List<EnderecoDto> encontrar(){
        List<EnderecoDto> listaDto = new ArrayList<EnderecoDto>();
        
        // Converte a lista de objetos da entidade em objetos dto para transferencia
        for(Endereco endereco: enderecoDB.findAll()) {
            listaDto.add(new EnderecoDto(
        		endereco.getCodigo(), endereco.getCep(), endereco.getLogradouro(),
                endereco.getNumero(), endereco.getBairro(), 
                endereco.getMunicipio(), endereco.getEstado(), endereco.getPessoa().getCodigo()));
        }

        return listaDto;
    }

    public List<EnderecoDto> encontrarPorPessoa(Long pessoa){
        List<EnderecoDto> listaDto = new ArrayList<EnderecoDto>();
        
        // Converte a lista de objetos da entidade em objetos dto para transferencia
        for(Endereco endereco: enderecoDB.encontrarPorCodigoPessoa(pessoa)) {
            listaDto.add(new EnderecoDto(
        		endereco.getCodigo(), endereco.getCep(), endereco.getLogradouro(),
                endereco.getNumero(), endereco.getBairro(), 
                endereco.getMunicipio(), endereco.getEstado(), endereco.getPessoa().getCodigo()));
        }

        return listaDto;
    }    

   public boolean salvar(EnderecoDto enderecoDto){
       try {
            Endereco endereco = null;
           if(enderecoDto.getCodigo() != null) {
                endereco = new Endereco(
                    enderecoDto.getCodigo(), enderecoDto.getCep(), enderecoDto.getLogradouro(),
                    enderecoDto.getNumero(), enderecoDto.getBairro(), 
                    enderecoDto.getMunicipio(), enderecoDto.getEstado(), pessoaService.encontrarPorId(Long.valueOf(enderecoDto.getPessoa())));            
           } else {
                endereco = new Endereco(
                    enderecoDto.getCep(), enderecoDto.getLogradouro(),
                    enderecoDto.getNumero(), enderecoDto.getBairro(), 
                    enderecoDto.getMunicipio(), enderecoDto.getEstado(), pessoaService.encontrarPorId(Long.valueOf(enderecoDto.getPessoa())));                        
           }


       	enderecoDB.save(endereco);
        return true;
       } catch (Exception e) {
           return false;
       }
   }
 
   public ResponseEntity<String> remover(long id){
       try {
                Endereco endereco = enderecoDB.findById(id).get();
                enderecoDB.delete(endereco);           

           return ResponseEntity.ok().body("Removido objeto de id: "+id);
       } catch (Exception e) {
           return ResponseEntity.notFound().build();
       }
   }  
}
