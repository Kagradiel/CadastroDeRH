package com.generation.RHSys.dto;

import java.math.BigDecimal;

import com.generation.RHSys.model.Cargo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CargoUpdateDTO {
	
	@NotNull(message = "O atributo ID é obrigatório")
    private Long id;
	
	@NotBlank(message = "O atributo cargo é obrigatório")
	private String cargo;
	
	@NotBlank(message = "O salário deve ser registrado")
	@Digits(integer = 5, fraction = 2, message = "O salario esperado deve conter 5 digitos inteiros com 2 casas decimais")
	private BigDecimal salario;

	public Cargo toEntity() {
		Cargo cargo = new Cargo();
	
		cargo.setId(this.id);
		cargo.setCargo(this.cargo);
		cargo.setSalario(this.salario);
		
		return cargo;
	}

}
