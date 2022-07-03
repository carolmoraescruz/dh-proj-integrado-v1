package br.com.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bridge.domain.entity.PessoaFisica;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository repository;
	
	public PessoaFisica insert(PessoaFisica aluno) {
		return repository.save(aluno);
	}
	
	public List<PessoaFisica> findAll() {
		return repository.findAll();
	}
	
	public PessoaFisica findById(Long id) {
		PessoaFisica entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return entity;
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public PessoaFisica update(PessoaFisica aluno) {
		PessoaFisica entity = findById(aluno.getIdPessoa());
		entity.setNome(aluno.getNome());
		entity.setEmail(aluno.getEmail());
		entity.setEndereco(aluno.getEndereco());
		entity.setSobrenome(aluno.getSobrenome());
		entity.setNomeSocial(aluno.getNomeSocial());
		entity.setCpf(aluno.getCpf());
		entity.setDataNascimento(aluno.getDataNascimento());
		entity.setTipoPcd(aluno.getTipoPcd());
		entity.setCvLinkedin(aluno.getCvLinkedin());
		return repository.save(entity);
	}

}
