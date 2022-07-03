package br.com.bridge.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@Size(max = 100)
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max = 150)
	@Column(name = "endereco")
	private String endereco;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "cidade")
	private String cidade;
	
	@NotBlank
	@Size(max = 15)
	@Column(name = "telefone")
	private String telefone;

}