package com.generation.RHSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.RHSys.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

	public List <Cargo> findByCargoContainingIgnoreCase(@Param("cargo") String cargo); 
}
