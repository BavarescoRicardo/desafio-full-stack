package br.edu.unoesc.desafiofullstack.dto;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDto {

    private Long codigo;
    private String nome;
    private String CPF;
    private Date dataNascimento;
    private String sexo;    
    
}
