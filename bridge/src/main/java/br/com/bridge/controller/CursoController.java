package br.com.bridge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bridge.domain.entity.Curso;
import br.com.bridge.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	CursoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso create(@Valid @RequestBody Curso curso) {
		return service.insert(curso);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso update(@Valid @RequestBody Curso curso) {
		return service.update(curso);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
