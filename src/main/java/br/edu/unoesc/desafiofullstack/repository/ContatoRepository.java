package br.edu.unoesc.desafiofullstack.repository;
import br.edu.unoesc.desafiofullstack.model.Contato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

    @Query("select c from Contato c where c.pessoa.codigo = ?1")
    List<Contato> encontrarPorCodigoPessoa(Long codigoPessoa);        
 
}
