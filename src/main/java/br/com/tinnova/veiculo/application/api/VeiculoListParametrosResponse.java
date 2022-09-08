package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.stream.Collectors;

import br.com.tinnova.veiculo.domain.Marca;
import br.com.tinnova.veiculo.domain.StatusVeiculo;
import br.com.tinnova.veiculo.domain.Veiculo;
import lombok.Value;

@Value
public class VeiculoListParametrosResponse {
	private Marca marca;
    private Integer ano;
    private String descricao;
    private String cor;
    private StatusVeiculo status;

    public static List<VeiculoListParametrosResponse> converte(List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(VeiculoListParametrosResponse::new)
                .collect(Collectors.toList());
    }

    public VeiculoListParametrosResponse(Veiculo veiculo) {
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.descricao = veiculo.getDescricao();
        this.cor = veiculo.getCor();
        this.status = veiculo.getStatus();
    }
}