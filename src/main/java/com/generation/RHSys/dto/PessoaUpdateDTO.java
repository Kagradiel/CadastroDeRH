package com.generation.RHSys.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PessoaUpdateDTO {
	
	@NotNull(message = "O atributo ID é obrigatório")
	@Schema(description = "Id do funcionario", example = "5")
	private Long id;
	
	@NotNull(message = "O Atributo Nome é obrigatório")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	@Schema(description = "Nome do funcionario", example = "Antonio Garcia")
	private String nome;
	
	@NotNull(message = "O Atributo CPF é obrigatório")
	@Schema(description = "CPF do funcionario", example = "12312312312")
	private String cpf;

	@NotNull(message = "O Atributo Endereco é obrigatório")
	@Size(min = 10, max = 255, message = "O atributo deve conter no mínimo 10 e no máximo 255 caracteres")
	@Schema(description = "Endereço do funcionario", example = "Rua nao sei oq nao sei oq la")
	private String endereco;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "O Atributo Data de nascimento é obrigatório")
	@Schema(description = "Data de nascimento do funcionario", example = "2024-02-01")
	private LocalDate dataNascimento;
	
	@JsonIgnoreProperties("pessoa")
	private PessoaCargoDTO cargo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public PessoaCargoDTO getCargo() {
		return cargo;
	}

	public void setCargo(PessoaCargoDTO cargo) {
		this.cargo = cargo;
	}
	

}
