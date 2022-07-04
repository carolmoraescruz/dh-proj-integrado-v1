package br.com.bridge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bridge.domain.vo.v1.PessoaJuridicaVO;
import br.com.bridge.service.PessoaJuridicaService;

@RestController
@RequestMapping("/empresas/v1")
public class PessoaJuridicaController {
	
	@Autowired
	PessoaJuridicaService service;
	
	@GetMapping(produces = {"application/json", "application/xml"})
	@ResponseStatus(value = HttpStatus.OK)
	public List<PessoaJuridicaVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaJuridicaVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	@ResponseStatus(value = HttpStatus.CREATED)
	public PessoaJuridicaVO create(@Valid @RequestBody PessoaJuridicaVO empresa) {
		return service.insert(empresa);
	}
	
	@PutMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaJuridicaVO update(@Valid @RequestBody PessoaJuridicaVO empresa) {
		return service.update(empresa);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
