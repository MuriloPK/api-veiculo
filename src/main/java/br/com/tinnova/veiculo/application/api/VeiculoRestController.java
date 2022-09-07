package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;

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
	@Override
	public List<VeiculoListEstoqueResponse> getVeiculosEmEstoque() {
		log.info("[inicia] VeiculoRestController - getVeiculosEmEstoque");
		List<VeiculoListEstoqueResponse> veiculosEstoque = veiculoService.listaEstoqueVeiculos();
		log.info("[finaliza] VeiculoRestController - getVeiculosEmEstoque");
		return veiculosEstoque;
	}

	@Override
	public VeiculoDetalhadoResponse getVeiculoAtravesId(UUID idVeiculo) {
		log.info("[inicia] VeiculoRestController - getVeiculoAtravesId");
		log.info("[idVeiculo]{}", idVeiculo);
		VeiculoDetalhadoResponse veiculoDetalhado = veiculoService.buscaVeiculoAtravesId(idVeiculo);
		log.info("[finaliza] VeiculoRestController - getVeiculoAtravesId");
		return veiculoDetalhado;
	}

	@Override
	public void deletaVeiculoAtravesId(UUID idVeiculo) {
		log.info("[inicia] VeiculoRestController - deletaVeiculoAtravesId");
		log.info("[idVeiculo]{}", idVeiculo);
		veiculoService.deletaVeiculoAtravesId(idVeiculo);
		log.info("[finaliza] VeiculoRestController - deletaVeiculoAtravesId");
		
	}

	@Override
	public void putAlteraVeiculo(UUID idVeiculo, @Valid VeiculoAlteracaoRequest veiculoAlteracaoRequest) {
		log.info("[inicia] VeiculoRestController - putAlteraVeiculo");
		log.info("[idVeiculo]{}", idVeiculo);
		veiculoService.putAlteraVeiculo(idVeiculo, veiculoAlteracaoRequest);
		log.info("[inicia] VeiculoRestController - putAlteraVeiculo");

	}

	@Override
	public void patchAtualizaStatusVeiculo(UUID idVeiculo, @Valid VeiculoAlteraStatusRequest veiculoAlteraStatusRequest) {
		log.info("[inicia]VeiculoRestController - patchAtualizaStatusVeiculo");
		log.info("[idVeiculo]{}", idVeiculo);
		veiculoService.patchAtualizaStatusVeiculo(idVeiculo, veiculoAlteraStatusRequest);
		log.info("[finaliza]VeiculoRestController - patchAtualizaStatusVeiculo");
		
	}

}