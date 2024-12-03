package com.generation.RHSys.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O Atributo Nome é obrigatório")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	private String nome;
	
	@NotNull(message = "O Atributo CPF é obrigatório")
	private String cpf;

	@NotNull(message = "O Atributo Endereco é obrigatório")
	@Size(min = 10, max = 255, message = "O atributo deve conter no mínimo 10 e no máximo 255 caracteres")
	private String endereco;

	@NotNull(message = "O Atributo Data de nascimento é obrigatório")
	private Date dataNascimento;

	@UpdateTimestamp
	private LocalDateTime dataAdmissao;
}
