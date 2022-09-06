package br.com.tinnova.veiculo.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.tinnova.veiculo.application.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
@RequiredArgsConstructor
public class VeiculoRestController implements VeiculoAPI {

	private final VeiculoService veiculoService;

	@Override
	public VeiculoResponse postVeiculo(@Valid VeiculoRequest veiculoRequest) {
		log.info("[inicia] VeiculoRestController - postVeiculo");
		VeiculoResponse veiculoCriado = veiculoService.criaVeiculo(veiculoRequest);
		log.info("[finaliza] VeiculoRestController - postVeiculo");
		return veiculoCriado;
	}

	@Override
	public List<VeiculoListResponse> getTodosVeiculos() {
		log.info("[inicia] VeiculoRestController - getTodosVeiculos");
		List<VeiculoListResponse> veiculos = veiculoService.buscaTodosVeiculos();
		log.info("[finaliza] VeiculoRestController - getTodosVeiculos");
		return veiculos;
	}
}