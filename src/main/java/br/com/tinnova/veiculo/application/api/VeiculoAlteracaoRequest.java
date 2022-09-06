package br.com.tinnova.veiculo.application.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tinnova.veiculo.domain.StatusVeiculo;
import lombok.Value;

@Value
public class VeiculoAlteracaoRequest {
	@NotBlank
	private String nomeVeiculo;
	@NotBlank
	private String marca;
	@NotNull
	private Integer ano;
	private String descricao;
	private StatusVeiculo status;
}
