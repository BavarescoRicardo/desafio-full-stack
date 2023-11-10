package br.edu.unoesc.desafiofullstack.repository;
import br.edu.unoesc.desafiofullstack.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
 
}
