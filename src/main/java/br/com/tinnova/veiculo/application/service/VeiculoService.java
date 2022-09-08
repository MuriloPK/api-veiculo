package br.com.tinnova.veiculo.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.tinnova.veiculo.application.api.VeiculoAlteraStatusRequest;
import br.com.tinnova.veiculo.application.api.VeiculoAlteracaoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoDetalhadoResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListEstoqueResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListFabricacaoResponse;
import br.com.tinnova.veiculo.application.api.VeiculoListResponse;
import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoResponse;

public interface VeiculoService {
	VeiculoResponse criaVeiculo(@Valid VeiculoRequest veiculoRequest);
	List<VeiculoListResponse> buscaTodosVeiculos();
	VeiculoDetalhadoResponse buscaVeiculoAtravesId(UUID idVeiculo);
	void deletaVeiculoAtravesId(UUID idVeiculo);
	void putAlteraVeiculo(UUID idVeiculo, @Valid VeiculoAlteracaoRequest veiculoAlteracaoRequest);
	void patchAtualizaStatusVeiculo(UUID idVeiculo, @Valid VeiculoAlteraStatusRequest veiculoAlteraStatusRequest);
	List<VeiculoListEstoqueResponse> listaEstoqueVeiculos();
	List<VeiculoListFabricacaoResponse> listaAnoFabricacaoVeiculos(Integer ano);
}