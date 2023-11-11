package br.edu.unoesc.desafiofullstack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstack.dto.ListaPessoaDto;
import br.edu.unoesc.desafiofullstack.dto.PessoaDto;
import br.edu.unoesc.desafiofullstack.model.Pessoa;
import br.edu.unoesc.desafiofullstack.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaDB;


    public Optional<Pessoa> encontrarPorId(Long id){        
        return pessoaDB.findById(id);
    }

    public List<ListaPessoaDto> encontrar(){
        List<ListaPessoaDto> listaDto = new ArrayList<ListaPessoaDto>();
        
        // Converte a lista de objetos da entidade em objetos dto para transferencia
        for(Pessoa pessoa: pessoaDB.findAll()) {
            listaDto.add(new ListaPessoaDto(
        		pessoa.getCodigo(), pessoa.getNome(), pessoa.getCPF(), pessoa.getDataNascimento(), pessoa.getSexo()));
        }

        return listaDto;
    }

   public boolean salvar(PessoaDto pessoaDto){
       try {
           // Define objeto  participante para salvar no banco de dados a partir do dto recebido
       	Pessoa pessoa = new Pessoa(
       			pessoaDto.getNome(), pessoaDto.getCPF(), pessoaDto.getDataNascimento(), pessoaDto.getSexo());

       	pessoaDB.save(pessoa);
        return true;
       } catch (Exception e) {
           return false;
       }
   }
//    
//    public PessoaDto atualizar(PessoaDto endereco, long id){
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
//            this.pessoaDB.save(e);    
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
//                // pessoaDB.removeByIdParticipante(participanteDto.getCodigo());                 
//                Endereco endereco = pessoaDB.findById(participanteDto.getCodigo()).get();
//                pessoaDB.deleteById(endereco.getId());
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
