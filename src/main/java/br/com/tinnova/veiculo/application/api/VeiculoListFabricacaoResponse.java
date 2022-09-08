package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.tinnova.veiculo.domain.Veiculo;
import lombok.Value;

@Value
public class VeiculoListFabricacaoResponse {
	private UUID idVeiculo;
	private String nomeVeiculo;
	private Integer ano;
	
	public static List<VeiculoListFabricacaoResponse> converte(List<Veiculo> veiculosAnoFabricacao) {
		return veiculosAnoFabricacao.stream()
				.map(VeiculoListFabricacaoResponse::new)
				.collect(Collectors.toList());
	}
	
	public VeiculoListFabricacaoResponse(Veiculo veiculo) {
		this.idVeiculo = veiculo.getIdVeiculo();
		this.nomeVeiculo = veiculo.getNomeVeiculo();
		this.ano = veiculo.getAno();
	}
}