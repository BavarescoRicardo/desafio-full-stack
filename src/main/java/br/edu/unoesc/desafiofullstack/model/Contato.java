package br.edu.unoesc.desafiofullstack.model;


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
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
//    private Pessoa fk;
    private String telefone;
    private String email;

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
