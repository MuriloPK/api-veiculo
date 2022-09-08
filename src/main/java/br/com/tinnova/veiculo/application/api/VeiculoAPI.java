package br.com.tinnova.veiculo.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tinnova.veiculo.domain.Marca;

@RestController
@RequestMapping("/v1/veiculo")
public interface VeiculoAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	VeiculoResponse postVeiculo(@Valid @RequestBody VeiculoRequest veiculoRequest);
	
	@GetMapping(value = "/todos")
	@ResponseStatus(code = HttpStatus.OK)
	List<VeiculoListResponse> getTodosVeiculos();
	
	@GetMapping(value = "/estoque")
	@ResponseStatus(code = HttpStatus.OK)
	List<VeiculoListEstoqueResponse> getVeiculosEmEstoque();
	
	@GetMapping(value = "/marca")
	@ResponseStatus(code = HttpStatus.OK)
	List<VeiculoListFabricanteResponse> getVeiculosMarca(@RequestParam(value ="marca") Marca marca);
	
	@GetMapping(value = "/ano")
	@ResponseStatus(code = HttpStatus.OK)
	List<VeiculoListFabricacaoResponse> getVeiculosAnoFabricacao(Integer ano);
		
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<VeiculoListParametrosResponse> listaVeiculosPorParametros(@RequestParam(value = "marca") Marca marca,
																   @RequestParam(value = "ano") Integer ano,
																   @RequestParam(value = "cor") String cor);

	@GetMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.OK)
	VeiculoDetalhadoResponse getVeiculoAtravesId(@PathVariable UUID idVeiculo);
	
	@PatchMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void  patchAtualizaStatusVeiculo(@PathVariable UUID idVeiculo,
			@Valid @RequestBody VeiculoAlteraStatusRequest veiculoAlteraStatusRequest);
	
	@PutMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void  putAlteraVeiculo(@PathVariable UUID idVeiculo,
			@Valid @RequestBody VeiculoAlteracaoRequest veiculoAlteracaoRequest);
	
	@DeleteMapping(value = "/{idVeiculo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void  deletaVeiculoAtravesId(@PathVariable UUID idVeiculo);
}