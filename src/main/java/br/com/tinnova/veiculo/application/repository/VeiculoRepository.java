package br.com.tinnova.veiculo.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.tinnova.veiculo.domain.Marca;
import br.com.tinnova.veiculo.domain.Veiculo;

public interface VeiculoRepository {
	Veiculo salva(Veiculo veiculo);
	List<Veiculo> buscaTodosVeiculos();
	Veiculo buscaVeiculoAtravesId(UUID idVeiculo);
	void deletaVeiculoAtravesId(Veiculo veiculo);
	List<Veiculo> listaEstoqueVeiculos();
	List<Veiculo> listaAnoFabricacaoVeiculos(Integer ano);
	List<Veiculo> buscaVeiculosPorParametros(Marca marca, Integer ano, String cor);
	List<Veiculo> listFabricanteVeiculos(Marca marca);
}