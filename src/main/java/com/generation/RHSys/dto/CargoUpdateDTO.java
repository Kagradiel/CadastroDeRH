package com.generation.RHSys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CargoUpdateDTO {
	
	@NotNull(message = "O atributo ID é obrigatório")
    private Long id;
	
	@NotBlank(message = "O atributo cargo é obrigatório")
	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
