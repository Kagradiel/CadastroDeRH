package com.generation.RHSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.RHSys.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public List<Pessoa> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}