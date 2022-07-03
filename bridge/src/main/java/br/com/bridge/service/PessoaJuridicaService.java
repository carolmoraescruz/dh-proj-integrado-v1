package br.com.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bridge.domain.entity.PessoaJuridica;
import br.com.bridge.exception.ResourceNotFoundException;
import br.com.bridge.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	
	@Autowired
	private PessoaJuridicaRepository repository;
	
	public PessoaJuridica insert(PessoaJuridica empresa) {
		return repository.save(empresa);
	}
	
	public List<PessoaJuridica> findAll() {
		return repository.findAll();
	}
	
	public PessoaJuridica findById(Long id) {
		PessoaJuridica entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com este id."));
		return entity;
	}
	
	public void delete(PessoaJuridica empresa) {
		repository.delete(empresa);
	}
	
	public PessoaJuridica update(PessoaJuridica empresa) {
		PessoaJuridica entity = findById(empresa.getIdPessoa());
		entity.setNome(empresa.getNome());
		entity.setEmail(empresa.getEmail());
		entity.setEndereco(empresa.getEndereco());
		entity.setCnpj(empresa.getCnpj());
		entity.setSobreInstituicao(empresa.getSobreInstituicao());
		return repository.save(entity);
	}

}
