package br.com.bridge.domain.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bridge.domain.entity.enums.TipoPCD;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = 1L;

	@Column(name = "sobrenome")
	private String sobrenome;

	@Column(name = "nomesocial")
	private String nomeSocial;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "tipo_pcd")
	private TipoPCD tipoPcd;

	@Column(name = "cv_linkedin")
	private String cvLinkedin;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "alunos")
	private Set<Turma> turmas = new HashSet<>();
	
	public Set<Turma> getTurmas() {
		return turmas;
	}
	
	public int calcularIdade(Date dataNascimento) {
		LocalDate dataNascimentoConvertida = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dataAtual = LocalDate.now();
		int idade = (Period.between(dataAtual, dataNascimentoConvertida)).getYears();
		return idade;
	}
	
}
