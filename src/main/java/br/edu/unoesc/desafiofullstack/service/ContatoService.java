package br.edu.unoesc.desafiofullstack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
           // Define objeto  participante para salvar no banco de dados a partir do dto recebido
       	Contato contato = new Contato(
       			contatoDto.getEmail(), contatoDto.getTelefone(), pessoaService.encontrarPorId(Long.valueOf(contatoDto.getPessoa())).get());

       	contatoDB.save(contato);
        return true;
       } catch (Exception e) {
           return false;
       }
   }
//    
//    public ContatoDto atualizar(ContatoDto endereco, long id){
//        try {
//            // Seleciona objeto salvo no banco pelo seu id e depois o atualiza com o dto
//            Endereco e = this.encontrarPorId(id).get();
//            if((endereco.getEndereco() != null) && (endereco.getEndereco().length() > 0)){
//                e.setEndereco(endereco.getEndereco());    
//            }
//
//            if((endereco.getCidade() != null) && (endereco.getCidade().length() > 0)){
//                e.setCidade(endereco.getCidade());    
//            }
//
//            this.contatoDB.save(e);    
//        } catch (Exception e) {
//            return null;
//        }
//        return endereco;
//    }
//
//    
//    public ResponseEntity<String> remover(long id){
//        try {
//            // Encontra objetos da lista de participantes pelo id da apresentacao
//            List<ParticipanteDto> participantes = participanteServices.encontrarPorApresentacaoId(id);
//            // remover endereco de todos os participantes 
//            for (ParticipanteDto participanteDto : participantes) {
//                // contatoDB.removeByIdParticipante(participanteDto.getCodigo());                 
//                Endereco endereco = contatoDB.findById(participanteDto.getCodigo()).get();
//                contatoDB.deleteById(endereco.getId());
//                // remover participante 
//                participanteServices.remover(participanteDto.getCodigo());
//                apresentacaoServices.remover(id);
//            }
//
//            // por fim remover apresentacao
//            apresentacaoServices.remover(id);
//            
//
//            return ResponseEntity.ok().body("Removido objeto de id: "+id);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }  
}
