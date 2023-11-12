package br.edu.unoesc.desafiofullstack.dto;

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
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String municipio;
    private String estado;
    private Long pessoa;    
    
}
