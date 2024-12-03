package com.generation.RHSys.dto;

import jakarta.validation.constraints.NotNull;

public class PessoaCargoDTO {
	@NotNull(message = "O Atributo ID é obrigatório")
	private Long id;

	public Long getId() {
		return id;
	}
}
