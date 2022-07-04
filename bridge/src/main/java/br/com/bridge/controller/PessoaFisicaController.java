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

import br.com.bridge.domain.vo.v1.PessoaFisicaVO;
import br.com.bridge.service.PessoaFisicaService;

@RestController
@RequestMapping("/alunos/v1")
public class PessoaFisicaController {
	
	@Autowired
	PessoaFisicaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PessoaFisicaVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaFisicaVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaFisicaVO create(@Valid @RequestBody PessoaFisicaVO aluno) {
		return service.insert(aluno);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaFisicaVO update(@Valid @RequestBody PessoaFisicaVO aluno) {
		return service.update(aluno);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
