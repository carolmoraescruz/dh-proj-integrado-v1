package br.com.bridge.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "horario")
	private String horario;

	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@Column(name = "data_termino")
	private LocalDate dataTermino;
		
}
