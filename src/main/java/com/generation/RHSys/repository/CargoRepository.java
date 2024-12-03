package com.generation.RHSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.RHSys.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	public List <Cargo> findByTituloContainingIgnoreCase(@Param("cargo") String cargo); 
}
