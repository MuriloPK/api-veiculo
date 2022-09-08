package br.com.tinnova.veiculo.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.tinnova.veiculo.application.api.VeiculoAlteraStatusRequest;
import br.com.tinnova.veiculo.application.api.VeiculoAlteracaoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoDetalhadoResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListEstoqueResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListFabricacaoResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListFabricanteResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListParametrosResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListResponse;
import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoResponse;
import br.com.tinnova.veiculo.application.repository.VeiculoRepository;
import br.com.tinnova.veiculo.domain.Marca;
import br.com.tinnova.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class VeiculoApplicationService implements VeiculoService {

	private final VeiculoRepository veiculoRepository;

	@Override
	public VeiculoResponse criaVeiculo(@Valid VeiculoRequest veiculoRequest) {
		log.info("[inicia] VeiculoApplicationService - criaVeiculo");
		Veiculo veiculo = veiculoRepository.salva(new Veiculo(veiculoRequest));
		log.info("[finaliza] VeiculoApplicationService - criaVeiculo");
		return VeiculoResponse.builder().idVeiculo(veiculo.getIdVeiculo()).build();
	}

	@Override
	public List<VeiculoListResponse> buscaTodosVeiculos() {
		log.info("[inicia] VeiculoApplicationService - buscaTodosVeiculos");
		List<Veiculo> veiculos = veiculoRepository.buscaTodosVeiculos();
		log.info("[finaliza] VeiculoApplicationService - buscaTodosVeiculos");
		return VeiculoListResponse.converte(veiculos);
	}

	@Override
	public List<VeiculoListEstoqueResponse> listaEstoqueVeiculos() {
		log.info("[inicia] VeiculoApplicationService - listaEstoqueVeiculos");
		List<Veiculo> veiculosEstoque = veiculoRepository.listaEstoqueVeiculos();
		log.info("[finaliza] VeiculoApplicationService - listaEstoqueVeiculos");
		return VeiculoListEstoqueResponse.converte(veiculosEstoque);
	}

	@Override
	public List<VeiculoListFabricanteResponse> listFabricanteVeiculos(Marca marca) {
		log.info("[inicia] VeiculoApplicationService - listaEstoqueVeiculos");
		List<Veiculo> veiculosPorFabricante = veiculoRepository.listFabricanteVeiculos(marca);
		log.info("[finaliza] VeiculoApplicationService - listaEstoqueVeiculos");
		return VeiculoListFabricanteResponse.converte(veiculosPorFabricante);
	}

	@Override
	public List<VeiculoListParametrosResponse> buscaVeiculosPorParametros(Marca marca, Integer ano, String cor) {
		log.info("[inicia] VeiculoApplicationService - buscaVeiculosPorParametros");
		List<Veiculo> veiculos = veiculoRepository.buscaVeiculosPorParametros(marca, ano, cor);
		log.info("[finaliza] VeiculoApplicationService - buscaVeiculosPorParametros");
		return VeiculoListParametrosResponse.converte(veiculos);
	}

	@Override
	public List<VeiculoListFabricacaoResponse> listaAnoFabricacaoVeiculos(Integer ano) {
		log.info("[inicia] VeiculoApplicationService - listaAnoFabricacaoVeiculos");
		List<Veiculo> veiculosAnoFabricacao = veiculoRepository.listaAnoFabricacaoVeiculos(ano);
		log.info("[finaliza] VeiculoApplicationService - listaAnoFabricacaoVeiculos");
		return VeiculoListFabricacaoResponse.converte(veiculosAnoFabricacao);

	}

	@Override
	public VeiculoDetalhadoResponse buscaVeiculoAtravesId(UUID idVeiculo) {
		log.info("[inicia] VeiculoApplicationService - buscaVeiculoAtravesId");
		Veiculo veiculo = veiculoRepository.buscaVeiculoAtravesId(idVeiculo);
		log.info("[finalzia] VeiculoApplicationService - buscaVeiculoAtravesId");
		return new VeiculoDetalhadoResponse(veiculo);
	}

	@Override
	public void deletaVeiculoAtravesId(UUID idVeiculo) {
		log.info("[inicia] VeiculoApplicationService - deletaVeiculoAtravesId");
		Veiculo veiculo = veiculoRepository.buscaVeiculoAtravesId(idVeiculo);
		veiculoRepository.deletaVeiculoAtravesId(veiculo);
		log.info("[finaliza] VeiculoApplicationService - deletaVeiculoAtravesId");

	}

	@Override
	public void putAlteraVeiculo(UUID idVeiculo, @Valid VeiculoAlteracaoRequest veiculoAlteracaoRequest) {
		log.info("[inicia] VeiculoApplicationService - putAlteraVeiculo");
		Veiculo veiculo = veiculoRepository.buscaVeiculoAtravesId(idVeiculo);
		veiculo.altera(veiculoAlteracaoRequest);
		veiculoRepository.salva(veiculo);
		log.info("[inicia] VeiculoApplicationService - putAlteraVeiculo");

	}

	@Override
	public void patchAtualizaStatusVeiculo(UUID idVeiculo,
			@Valid VeiculoAlteraStatusRequest veiculoAlteraStatusRequest) {
		log.info("[inicia] VeiculoApplicationService - patchAtualizaStatusVeiculo");
		Veiculo veiculo = veiculoRepository.buscaVeiculoAtravesId(idVeiculo);
		veiculo.atualiza(veiculoAlteraStatusRequest);
		veiculoRepository.salva(veiculo);
		log.info("[finaliza] VeiculoApplicationService - patchAtualizaStatusVeiculo");
	}

}