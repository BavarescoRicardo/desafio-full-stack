package br.edu.unoesc.desafiofullstack.model;

import java.sql.Date;
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

    public Pessoa(String nome, String cPF, Date dataNascimento, String sexo) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}            
    
}
