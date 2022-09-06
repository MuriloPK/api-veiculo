package br.com.tinnova.veiculo.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinnova.veiculo.domain.Veiculo;

public interface VeiculoSpringDataJPARepository extends JpaRepository<Veiculo, UUID> {

}
