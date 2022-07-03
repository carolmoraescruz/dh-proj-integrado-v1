package br.com.bridge.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pessoa_juridica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PessoaJuridica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "sobre_instituicao")
	private String sobreInstituicao;
	
}
