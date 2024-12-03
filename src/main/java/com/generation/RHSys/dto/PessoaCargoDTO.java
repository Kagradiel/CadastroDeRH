package com.generation.RHSys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class PessoaCargoDTO {
	
	@NotNull(message = "O Atributo ID é obrigatório")
	@Schema(description = "Id do cargo", example = "5")
	private Long id;

	public Long getId() {
		return id;
	}
}
