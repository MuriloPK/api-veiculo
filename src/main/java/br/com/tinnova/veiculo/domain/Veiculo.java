package br.com.tinnova.veiculo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tinnova.veiculo.application.api.VeiculoAlteraStatusRequest;
import br.com.tinnova.veiculo.application.api.VeiculoAlteracaoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idVeiculo;
	@NotBlank
	private String nomeVeiculo;
	@NotBlank
	private String marca;
	@NotNull
	private Integer ano;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusVeiculo status;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAtualizacao;

	public Veiculo(VeiculoRequest veiculoRequest) {
		this.nomeVeiculo = veiculoRequest.getNomeVeiculo();
		this.marca = veiculoRequest.getMarca();
		this.ano = veiculoRequest.getAno();
		this.descricao = veiculoRequest.getDescricao();
		this.status = StatusVeiculo.EM_ESTOQUE;
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(VeiculoAlteracaoRequest veiculoAlteracaoRequest) {
		this.nomeVeiculo = veiculoAlteracaoRequest.getNomeVeiculo();
		this.marca = veiculoAlteracaoRequest.getMarca();
		this.ano = veiculoAlteracaoRequest.getAno();
		this.descricao = veiculoAlteracaoRequest.getDescricao();
		this.dataHoraDaUltimaAtualizacao = LocalDateTime.now();
	}

	public void atualiza(VeiculoAlteraStatusRequest veiculoAlteraStatusRequest) {
		this.nomeVeiculo = veiculoAlteraStatusRequest.getNomeVeiculo();
		this.marca = veiculoAlteraStatusRequest.getMarca();
		this.ano = veiculoAlteraStatusRequest.getAno();
		this.descricao = veiculoAlteraStatusRequest.getDescricao();
		this.status = veiculoAlteraStatusRequest.getStatus();
		this.dataHoraDaUltimaAtualizacao = LocalDateTime.now();
	}
}