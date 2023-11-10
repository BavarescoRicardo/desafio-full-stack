package br.edu.unoesc.desafiofullstack.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
//    private Pessoa fk
    private String cep;
    private Date logradouro;
    private String numero;
    private String bairro;
    private String municio;
    private String estado;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "evento_id")
//    private Evento evento;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jurado")
//    private List<Nota> notas;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jurado")
//    private List<NotaFinal> notasfinais;                
    
}
