package com.generation.RHSys.dto;

import jakarta.validation.constraints.NotBlank;

public class CargoCreateDTO {
	
	@NotBlank(message = "O atributo cargo é obrigatório")
	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
