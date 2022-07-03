package br.com.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bridge.domain.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNomeCurso(String nomeCurso);

}
