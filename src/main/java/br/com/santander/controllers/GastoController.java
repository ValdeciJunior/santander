package br.com.santander.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.dtos.GastoDTO;
import br.com.santander.entities.Gasto;
import br.com.santander.services.GastoService;
import br.com.santander.services.UserDetailsServiceImpl;

@RestController
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	private UserDetailsServiceImpl userDetails;
	
	@Autowired
	private GastoService gastoService;
	
	@PostMapping
	public GastoDTO cadastrar(@RequestBody GastoDTO gasto) {
		return gastoService.cadastrar(gasto, userDetails.get().getCodigoUsuario());
	}
	
	@GetMapping("/{uuid}")
	public GastoDTO get(@PathVariable("uuid") String uuid) {
		return gastoService.getDTO(uuid, userDetails.get().getCodigoUsuario());
	}
	
	@GetMapping
	public List<GastoDTO> gastos(){
		return gastoService.listar(userDetails.get().getCodigoUsuario());
	}
	
	@GetMapping("/por-data/{data}")
	public List<GastoDTO> gastosPorData(@PathVariable("data") String data){
		return gastoService.listarPorData(data, userDetails.get().getCodigoUsuario());
	}
	
	@PutMapping("/altera-categoria/{uuid}")
	public GastoDTO alterarCategoria(@RequestParam("categoria") String categoria, @PathVariable("uuid") String uuid) {
		return gastoService.alterarCategoria(categoria, uuid, userDetails.get().getCodigoUsuario());
	}
	
	@GetMapping("/pesquisar-categoria/{categoria}")
	public List<String> pesquisarCategorias(@PathVariable("categoria")String categoria){
		return gastoService.pesquisarCategorias(categoria, userDetails.get().getCodigoUsuario());
	}
	
	
}























