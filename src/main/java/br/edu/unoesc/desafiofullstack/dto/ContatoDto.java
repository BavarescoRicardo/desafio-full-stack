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
public class ContatoDto {

    private Long codigo;
    private String telefone;
    private String email;
    private Long pessoa;        
    
}
