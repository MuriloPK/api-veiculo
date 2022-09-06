package br.com.tinnova.veiculo.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinnova.veiculo.domain.Veiculo;

public interface VeiculoSpringJPARepository extends JpaRepository<Veiculo, UUID> {

}
