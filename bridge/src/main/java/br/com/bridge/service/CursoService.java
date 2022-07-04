package br.com.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bridge.adapter.DozerConverter;
import br.com.bridge.domain.entity.Curso;
import br.com.bridge.domain.vo.v1.CursoVO;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	public CursoVO insert(CursoVO curso) {
		var entity = DozerConverter.parseObject(curso, Curso.class);
		var vo = DozerConverter.parseObject(repository.save(entity), CursoVO.class);
		return vo;
	}

	public List<CursoVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), CursoVO.class);
	}

	public CursoVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return DozerConverter.parseObject(entity, CursoVO.class);
	}
	
	public Curso findByName(String nomeCurso) {
		return repository.findByNomeCurso(nomeCurso);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		repository.delete(entity);
	}
	
	public CursoVO update(CursoVO curso) {
		var entity = repository.findById(curso.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		entity.setNomeCurso(curso.getNomeCurso());
		entity.setDuracao(curso.getDuracao());
		entity.setAreaInteresse(curso.getAreaInteresse());
		entity.setSobreCurso(curso.getSobreCurso());
		entity.setEscolaridadeMinima(curso.getEscolaridadeMinima());
		entity.setLinkCadastro(curso.getLinkCadastro());
		
		var vo = DozerConverter.parseObject(repository.save(entity), CursoVO.class);
		return vo;
	}

}
