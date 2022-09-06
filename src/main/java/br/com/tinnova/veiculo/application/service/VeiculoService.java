package br.com.tinnova.veiculo.application.service;

import javax.validation.Valid;

import br.com.tinnova.veiculo.application.api.VeiculoRequest;
import br.com.tinnova.veiculo.application.api.VeiculoResponse;

public interface VeiculoService {

	VeiculoResponse criaVeiculo(@Valid VeiculoRequest veiculoRequest);

}
