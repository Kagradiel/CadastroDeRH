package com.generation.RHSys.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CargoCreateDTO {
	
	@NotBlank(message = "O atributo cargo é obrigatório")
	@Schema(description = "Cargo do funcionário", example = "Software Engineer")
	private String cargo;
	
	@NotNull(message = "O salário deve ser registrado")
	@Digits(integer = 5, fraction = 2, message = "O salario esperado deve conter 5 digitos inteiros com 2 casas decimais")
	@Schema(description = "salario do funcionario", example = "8000.52")
	private BigDecimal salario;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	

}
