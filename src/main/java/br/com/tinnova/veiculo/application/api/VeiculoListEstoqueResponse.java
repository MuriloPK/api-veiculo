package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.tinnova.veiculo.domain.StatusVeiculo;
import br.com.tinnova.veiculo.domain.Veiculo;
import lombok.Value;

@Value
public class VeiculoListEstoqueResponse {

	private UUID idVeiculo;
	private String nomeVeiculo;
	private Integer ano;
	private StatusVeiculo status;

	public static List<VeiculoListEstoqueResponse> converte(List<Veiculo> veiculosEstoque) {
		return veiculosEstoque.stream().map(VeiculoListEstoqueResponse::new).collect(Collectors.toList());
	}

	public VeiculoListEstoqueResponse(Veiculo veiculo) {
		this.idVeiculo = veiculo.getIdVeiculo();
		this.nomeVeiculo = veiculo.getNomeVeiculo();
		this.ano = veiculo.getAno();
		this.status = veiculo.getStatus();
	}
}