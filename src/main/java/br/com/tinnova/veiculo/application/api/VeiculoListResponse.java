package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.tinnova.veiculo.domain.StatusVeiculo;
import br.com.tinnova.veiculo.domain.Veiculo;
import lombok.Value;
@Value
public class VeiculoListResponse {

	private UUID idVeiculo;
	private String nomeVeiculo;
	private Integer ano;
	private StatusVeiculo status;
	
	public static List<VeiculoListResponse> converte(List<Veiculo> veiculos) {
		return veiculos.stream()
				.map(VeiculoListResponse::new)
				.collect(Collectors.toList());
	}

	public VeiculoListResponse(Veiculo veiculo) {
		this.idVeiculo = veiculo.getIdVeiculo();
		this.nomeVeiculo = veiculo.getNomeVeiculo();
		this.ano = veiculo.getAno();
		this.status = veiculo.getStatus();
	}
}