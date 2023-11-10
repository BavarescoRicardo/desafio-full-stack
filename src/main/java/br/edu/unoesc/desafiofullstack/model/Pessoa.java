package br.edu.unoesc.desafiofullstack.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nome;
    private String CPF;
    private Date dataNascimento;
    private String sexo;       
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Contato> contatos;        
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Endereco> enderecos;            
    
}
