package com.generation.RHSys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.RHSys.model.Cargo;
import com.generation.RHSys.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
public class CargoController {
	
	public CargoRepository cargoRepository;
	
	@GetMapping
	public ResponseEntity<List<Cargo>> getAll(){
		return ResponseEntity.ok(cargoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cargo> getById(@PathVariable Long id){
		return cargoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/cargo/{cargo}")
	public ResponseEntity<List<Cargo>> getBycargo(@PathVariable String cargo){
		return ResponseEntity.ok(cargoRepository
				.findByTituloContainingIgnoreCase(cargo));
	}
	
	@PostMapping
	public ResponseEntity<Cargo> post(Cargo cargo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cargoRepository.save(cargo));
	}
	
	@PutMapping
	public ResponseEntity<Cargo> put(Cargo cargo){
		return cargoRepository.findById(cargo.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
						.body(cargoRepository.save(cargo)))
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
