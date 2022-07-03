package br.com.bridge.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bridge.domain.entity.enums.AreaInteresse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cursos")
@Data
@NoArgsConstructor
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long idCurso;

	@Column(name = "nome_curso")
	private String nomeCurso;

	@Column(name = "duracao")
	private String duracao;

	@Column(name = "area_interesse")
	private AreaInteresse areaInteresse;

	@Column(name = "sobre_curso")
	private String sobreCurso;

	@Column(name = "escolaridade_minima")
	private String escolaridadeMinima;

	@Column(name = "link_cadastro")
	private String linkCadastro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public List<Turma> getTurmas() {
		return turmas;
	}
		
}
