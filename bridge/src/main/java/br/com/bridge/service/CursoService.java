package br.com.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bridge.domain.entity.Curso;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public Curso insert(Curso curso) {
		return repository.save(curso);
	}
	
	public List<Curso> findAll() {
		return repository.findAll();
	}
	
	public Curso findById(Long id) {
		Curso entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return entity;
	}
	
	public void delete(Curso curso) {
		repository.delete(curso);
	}
	
	public Curso update(Curso curso) {
		Curso entity = findById(curso.getIdCurso());
		entity.setNomeCurso(curso.getNomeCurso());
		entity.setDuracao(curso.getDuracao());
		entity.setAreaInteresse(curso.getAreaInteresse());
		entity.setSobreCurso(curso.getSobreCurso());
		entity.setEscolaridadeMinima(curso.getEscolaridadeMinima());
		entity.setLinkCadastro(curso.getLinkCadastro());
		return repository.save(entity);
	}

}
