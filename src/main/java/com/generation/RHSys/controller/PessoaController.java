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

import com.generation.RHSys.dto.PessoaCreateDTO;
import com.generation.RHSys.dto.PessoaUpdateDTO;
import com.generation.RHSys.model.Cargo;
import com.generation.RHSys.model.Pessoa;
import com.generation.RHSys.repository.PessoaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Funcionários", description = "Operações relacionadas aos funcionários")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pessoa>> getAll() {
		return ResponseEntity.ok(pessoaRepository.findAll());

	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
		return pessoaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping(value = "/nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pessoa>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(pessoaRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping(
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    ) 
	public ResponseEntity<Pessoa> post(@Valid @RequestBody PessoaCreateDTO pessoaDTO){
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
		pessoa.setEndereco(pessoaDTO.getEndereco());
		
		Cargo cargo = new Cargo();
		cargo.setId(pessoaDTO.getCargo().getId());
		
		pessoa.setCargo(cargo);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(pessoaRepository.save(pessoa));
	}
	
	@PutMapping(
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	    ) 
	public ResponseEntity<Pessoa> put(@Valid @RequestBody PessoaUpdateDTO pessoaDTO) {
	    return pessoaRepository.findById(pessoaDTO.getId())
	            .map(pessoa -> 
	            {
	            	pessoa.setNome(pessoaDTO.getNome());
	            	pessoa.setCpf(pessoaDTO.getCpf());
	            	pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
	            	pessoa.setEndereco(pessoaDTO.getEndereco());
	            	
	            	Cargo cargo = new Cargo();
	        		cargo.setId(pessoaDTO.getCargo().getId());
	        		
	        		pessoa.setCargo(cargo);
                
	            	
	            	return ResponseEntity.status(HttpStatus.OK)
                        .body(pessoaRepository.save(pessoa));
	            })
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		if(pessoa.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		pessoaRepository.deleteById(id);
		
	}
	
}