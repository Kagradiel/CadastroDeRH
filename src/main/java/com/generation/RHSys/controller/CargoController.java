package com.generation.RHSys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.RHSys.dto.CargoCreateDTO;
import com.generation.RHSys.dto.CargoUpdateDTO;
import com.generation.RHSys.model.Cargo;
import com.generation.RHSys.repository.CargoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cargo")
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@Tag(name = "cargos", description = "Operações relacionadas aos cargos dos funcionários")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cargo>> getAll(){
		return ResponseEntity.ok(cargoRepository.findAll());
	}
	
	@GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cargo> getById(@PathVariable Long id){
		return cargoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping(value = "/cargo/{cargo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cargo>> getBycargo(@PathVariable String cargo){
		return ResponseEntity.ok(cargoRepository
				.findByCargoContainingIgnoreCase(cargo));
	}
	
	@PostMapping(
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    )
	public ResponseEntity<Cargo> post(@Valid @RequestBody CargoCreateDTO cargoDTO){
		
		Cargo cargo = new Cargo();
		cargo.setCargo(cargoDTO.getCargo());
		cargo.setSalario(cargoDTO.getSalario());
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cargoRepository.save(cargo));
	}
	
	@PutMapping(
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    )
	public ResponseEntity<Cargo> put(@Valid @RequestBody CargoUpdateDTO cargoDTO){
		return cargoRepository.findById(cargoDTO.getId())
				.map(cargo -> {
					
					cargo.setCargo(cargoDTO.getCargo());
					cargo.setSalario(cargoDTO.getSalario());
					
					return ResponseEntity.status(HttpStatus.CREATED)
					.body(cargoRepository.save(cargo));
				})
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional <Cargo> cargo = cargoRepository.findById(id);
		
		if(cargo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		cargoRepository.deleteById(id);
		
	}
	

}
