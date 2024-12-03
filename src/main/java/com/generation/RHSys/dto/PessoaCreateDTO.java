package com.generation.RHSys.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.generation.RHSys.model.Cargo;
import com.generation.RHSys.model.Pessoa;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PessoaCreateDTO {
	
	@NotNull(message = "O Atributo Nome é obrigatório")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	private String nome;
	
	@NotNull(message = "O Atributo CPF é obrigatório")
	private String cpf;

	@NotNull(message = "O Atributo Endereco é obrigatório")
	@Size(min = 10, max = 255, message = "O atributo deve conter no mínimo 10 e no máximo 255 caracteres")
	private String endereco;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "O Atributo Data de nascimento é obrigatório")
	private LocalDate dataNascimento;

	private PessoaCargoDTO cargo;
	
	public Pessoa toEntity() {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(this.nome);
		pessoa.setCpf(this.cpf);
		pessoa.setEndereco(this.endereco);
		pessoa.setDataNascimento(dataNascimento);
		
		Cargo cargo = new Cargo();
		
		cargo.setId(this.cargo.getId());
		pessoa.setCargo(cargo);
		
		return pessoa;
	}
}
