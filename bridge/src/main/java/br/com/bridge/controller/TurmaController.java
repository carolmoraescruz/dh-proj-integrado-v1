package br.com.bridge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bridge.domain.vo.v1.TurmaVO;
import br.com.bridge.service.TurmaService;

@RestController
@RequestMapping("/turmas/v1")
public class TurmaController {
	
	@Autowired
	TurmaService service;
	
	@GetMapping(produces = {"application/json", "application/xml"})
	public List<TurmaVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public TurmaVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	public TurmaVO create(@Valid @RequestBody TurmaVO turma) {
		return service.insert(turma);
	}
	
	@PutMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	public TurmaVO update(@Valid @RequestBody TurmaVO turma) {
		return service.update(turma);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
