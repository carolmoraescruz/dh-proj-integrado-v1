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

import br.com.bridge.domain.entity.PessoaJuridica;
import br.com.bridge.service.PessoaJuridicaService;

@RestController
@RequestMapping("/empresas")
public class PessoaJuridicaController {
	
	@Autowired
	PessoaJuridicaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PessoaJuridica> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaJuridica findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaJuridica create(@Valid @RequestBody PessoaJuridica empresa) {
		return service.insert(empresa);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaJuridica update(@Valid @RequestBody PessoaJuridica empresa) {
		return service.update(empresa);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
