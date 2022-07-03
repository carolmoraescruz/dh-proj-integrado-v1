package br.com.bridge.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_turmas")
@Data
@NoArgsConstructor
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long idTurma;

	@NotBlank
	@Size(max = 50)
	@Column(name = "horario")
	private String horario;

	@NotBlank
	@Size(max = 10)
	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@NotBlank
	@Size(max = 10)
	@Column(name = "data_termino")
	private LocalDate dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@ManyToMany
	@JoinTable(name = "tb_turma_aluno", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private Set<PessoaFisica> alunos = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_turma_empresa", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private Set<PessoaJuridica> empresas = new HashSet<>();
	
	public Set<PessoaFisica> getAlunos() {
		return alunos;
	}
	
	public Set<PessoaJuridica> getEmpresas() {
		return empresas;
	}
		
}
