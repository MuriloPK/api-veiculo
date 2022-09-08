package br.com.tinnova.veiculo.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.tinnova.veiculo.application.repository.VeiculoRepository;
import br.com.tinnova.veiculo.domain.StatusVeiculo;
import br.com.tinnova.veiculo.domain.Veiculo;
import br.com.tinnova.veiculo.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class VeiculoInfraRepository implements VeiculoRepository {

	private final VeiculoSpringDataJPARepository veiculoSpringDataJPARepository;

	@Override
	public Veiculo salva(Veiculo veiculo) {
		log.info("[inicia] VeiculoInfraRepository - salva");
		veiculoSpringDataJPARepository.save(veiculo);
		log.info("[finaliza] VeiculoInfraRepository - salva");
		return veiculo;
	}

	@Override
	public List<Veiculo> buscaTodosVeiculos() {
		log.info("[inicia] VeiculoInfraRepository - buscaTodosVeiculos");
		List<Veiculo> todosVeiculos = veiculoSpringDataJPARepository.findAll();
		log.info("[finaliza] VeiculoInfraRepository - buscaTodosVeiculos");
		return todosVeiculos;
	}

	@Override
	public List<Veiculo> listaEstoqueVeiculos() {
		log.info("[inicia] VeiculoInfraRepository - listaEstoqueVeiculos");
		List<Veiculo> veiculosEstoque = veiculoSpringDataJPARepository.findByStatus(StatusVeiculo.EM_ESTOQUE);
		log.info("[finaliza] VeiculoInfraRepository - listaEstoqueVeiculos");
		return veiculosEstoque;
	}

	@Override
	public List<Veiculo> listaAnoFabricacaoVeiculos(Integer ano) {
		log.info("[inicia] VeiculoInfraRepository - listaAnoFabricacaoVeiculos");
		List<Veiculo> veiculosAnoFabricacao = veiculoSpringDataJPARepository.findByAno(ano);
		log.info("[finaliza] VeiculoInfraRepository - listaAnoFabricacaoVeiculos");
		return veiculosAnoFabricacao;
	}
	
	@Override
	public List<Veiculo> buscaVeiculosPorParametros(String marca, Integer ano, String cor) {
		log.info("[inicia] VeiculoInfraRepository - buscaVeiculosPorParametros");
		List<Veiculo> veiculosPorParametros = veiculoSpringDataJPARepository.findByMarcaAndAnoAndCor(marca, ano, cor);
		log.info("[finaliza] VeiculoInfraRepository - buscaVeiculosPorParametros");
		return veiculosPorParametros;
	}

	@Override
	public Veiculo buscaVeiculoAtravesId(UUID idVeiculo) {
		log.info("[inicia] VeiculoInfraRepository - buscaVeiculoAtravesId");
		Veiculo veiculo = veiculoSpringDataJPARepository.findById(idVeiculo)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Veiculo não encontrado"));
		log.info("[finaliza] VeiculoInfraRepository - buscaVeiculoAtravesId");
		return veiculo;
	}

	@Override
	public void deletaVeiculoAtravesId(Veiculo veiculo) {
		log.info("[inicia] VeiculoInfraRepository - deletaVeiculoAtravesId");
		veiculoSpringDataJPARepository.delete(veiculo);
		log.info("[finaliza] VeiculoInfraRepository - deletaVeiculoAtravesId");

	}
}