package br.edu.unoesc.desafiofullstack.dto;

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
public class EnderecoDto {

    private Long codigo;
    @NotBlank(message= "O CEP é obrigatório")
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String municio;
    private String estado;
    private Long pessoa;    
    
}
