package br.com.tinnova.veiculo.application.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tinnova.veiculo.domain.Marca;
import lombok.Value;

@Value
public class VeiculoAlteracaoRequest {
	@NotBlank
	private String nomeVeiculo;
	private Marca marca;
	@NotNull
	private Integer ano;
	@NotBlank
	private String cor;
	private String descricao;
}
