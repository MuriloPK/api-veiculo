package br.com.tinnova.veiculo.infra;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinnova.veiculo.domain.Marca;
import br.com.tinnova.veiculo.domain.StatusVeiculo;
import br.com.tinnova.veiculo.domain.Veiculo;

public interface VeiculoSpringDataJPARepository extends JpaRepository<Veiculo, UUID> {

	List<Veiculo> findByStatus(StatusVeiculo status);
	List<Veiculo> findByAno(Integer ano);
	List<Veiculo> findByMarcaAndAnoAndCor(Marca marca, Integer ano, String cor);
	List<Veiculo> findByMarca(Marca marca);
	List<Veiculo> findByDataAtual(Calendar dataAtual);
	List<Veiculo> findByDataSemanda(Calendar dataSemanda);
}