package br.com.bridge.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bridge.domain.vo.v1.PessoaFisicaVO;
import br.com.bridge.service.PessoaFisicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Alunos Endpoint")
@RestController
@RequestMapping("/api/alunos/v1")
public class PessoaFisicaController {
	
	@Autowired
	PessoaFisicaService service;
	
	@CrossOrigin("localhost:8080")
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	@Operation(summary="Listar todos os alunos")
	@ResponseStatus(value = HttpStatus.OK)
	public List<PessoaFisicaVO> findAll() {
		List<PessoaFisicaVO> alunosVO = service.findAll();
		alunosVO.stream().forEach(a -> a.add(linkTo(methodOn(PessoaFisicaController.class).findById(a.getKey())).withSelfRel()));
		return alunosVO;
	}
	
	@CrossOrigin("localhost:8080")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	@Operation(summary="Listar alunos por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaFisicaVO findById(@PathVariable("id") Long id) {
		PessoaFisicaVO alunoVO = service.findById(id);
		alunoVO.add(linkTo(methodOn(PessoaFisicaController.class).findById(id)).withSelfRel());
		return alunoVO;
	}
	
	@PostMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	@Operation(summary="Cadastrar novo aluno")
	@ResponseStatus(value = HttpStatus.CREATED)
	public PessoaFisicaVO create(@Valid @RequestBody PessoaFisicaVO aluno) {
		PessoaFisicaVO alunoVO = service.insert(aluno);
		alunoVO.add(linkTo(methodOn(PessoaFisicaController.class).findById(alunoVO.getKey())).withSelfRel());
		return alunoVO;
	}
	
	@PutMapping(consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	@Operation(summary="Atualizar dados de aluno")
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaFisicaVO update(@Valid @RequestBody PessoaFisicaVO aluno) {
		PessoaFisicaVO alunoVO = service.update(aluno);
		alunoVO.add(linkTo(methodOn(PessoaFisicaController.class).findById(alunoVO.getKey())).withSelfRel());
		return alunoVO;
	}
	
	@DeleteMapping(value="/{id}")
	@Operation(summary="Deletar alunos por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
