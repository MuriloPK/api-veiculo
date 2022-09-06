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
}