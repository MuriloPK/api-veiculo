package br.com.tinnova.veiculo.application.api;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import br.com.tinnova.veiculo.domain.Veiculo;
import lombok.Value;

@Value
public class VeiculoListSemanaResponse {
	private Calendar dataAtual;
	
	public static List<VeiculoListSemanaResponse> converte(List<Veiculo> veiculosPorSemana) {
		return veiculosPorSemana.stream()
				.map(VeiculoListSemanaResponse::new)
				.collect(Collectors.toList());
	}

	public VeiculoListSemanaResponse(Veiculo veiculo) {
		this.dataAtual = Calendar.getInstance();
		}
}