package br.edu.unoesc.desafiofullstack.repository;
import br.edu.unoesc.desafiofullstack.model.Endereco;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
    @Query("select e from Endereco e where e.pessoa.codigo = ?1")
    List<Endereco> encontrarPorCodigoPessoa(Long codigoPessoa);    
 
}
