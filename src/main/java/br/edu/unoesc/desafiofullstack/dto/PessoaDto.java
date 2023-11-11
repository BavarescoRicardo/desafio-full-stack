package br.edu.unoesc.desafiofullstack.dto;
import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;

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
    
    @NotBlank(message= "O nome é obrigatório")
    private String nome;
    private String CPF;
    private Date dataNascimento;
    private String sexo;    
    
}
