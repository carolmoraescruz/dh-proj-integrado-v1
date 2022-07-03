package br.com.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bridge.domain.entity.Curso;
import br.com.bridge.domain.entity.Turma;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	public Turma insert(Turma turma) {
		return repository.save(turma);
	}
	
	public List<Turma> findAll() {
		return repository.findAll();
	}
	
	public Turma findById(Long id) {
		Turma entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return entity;
	}
	
	public void delete(Long id) {
		Turma entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		repository.delete(entity);
	}
	
	public Turma update(Turma turma) {
		Turma entity = findById(turma.getIdTurma());
		entity.setHorario(turma.getHorario());
		entity.setDataInicio(turma.getDataInicio());
		entity.setDataTermino(turma.getDataTermino());
		entity.setCurso(turma.getCurso());
		return repository.save(entity);
	}

}
