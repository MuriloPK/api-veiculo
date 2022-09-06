package br.com.tinnova.veiculo.application.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tinnova.veiculo.domain.StatusVeiculo;
import lombok.Value;

@Value
public class VeiculoRequest {

	@NotBlank
	private String nomeVeiculo;
	@NotBlank
	private String marca;
	@NotNull
	private Integer ano;
	private String descricao;
	@NotNull
	private StatusVeiculo status;
}
