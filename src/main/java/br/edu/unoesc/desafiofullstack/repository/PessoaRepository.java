package br.edu.unoesc.desafiofullstack.repository;
import br.edu.unoesc.desafiofullstack.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
 
}
