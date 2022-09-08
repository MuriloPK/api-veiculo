package br.com.tinnova.veiculo.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.tinnova.veiculo.domain.Marca;
import br.com.tinnova.veiculo.domain.StatusVeiculo;
import br.com.tinnova.veiculo.domain.Veiculo;
import lombok.Value;
@Value
public class VeiculoDetalhadoResponse {
	private UUID idVeiculo;
	private String nomeVeiculo;
	private Marca marca;
	private Integer ano;
	private String cor;
	private String descricao;
	private StatusVeiculo status;
	private LocalDateTime dataHoraDoCadastro;
	
	public VeiculoDetalhadoResponse(Veiculo veiculo) {
		this.idVeiculo = veiculo.getIdVeiculo();
		this.nomeVeiculo = veiculo.getNomeVeiculo();
		this.marca = veiculo.getMarca();
		this.ano = veiculo.getAno();
		this.cor = veiculo.getCor();
		this.descricao = veiculo.getDescricao();
		this.status = veiculo.getStatus();
		this.dataHoraDoCadastro = veiculo.getDataHoraDoCadastro();
	}
	
	
}
