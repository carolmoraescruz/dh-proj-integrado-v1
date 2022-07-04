package br.com.bridge.domain.vo.v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.bridge.domain.entity.Curso;
import br.com.bridge.domain.entity.PessoaFisica;
import br.com.bridge.domain.entity.PessoaJuridica;

public class TurmaVO extends RepresentationModel<TurmaVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Mapping("idTurma")
	private Long key;
	private String horario;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private Curso curso;
	private Set<PessoaFisica> alunos = new HashSet<>();
	private Set<PessoaJuridica> empresas = new HashSet<>();
	
	public Long getKey() {
		return key;
	}
	
	public void setKey(Long key) {
		this.key = key;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Set<PessoaFisica> getAlunos() {
		return alunos;
	}
	
	public Set<PessoaJuridica> getEmpresas() {
		return empresas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataInicio, dataTermino, horario, key);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurmaVO other = (TurmaVO) obj;
		return Objects.equals(dataInicio, other.dataInicio) && Objects.equals(dataTermino, other.dataTermino)
				&& Objects.equals(horario, other.horario) && Objects.equals(key, other.key);
	}

}
