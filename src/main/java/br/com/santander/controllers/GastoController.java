package br.com.santander.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.entities.Gasto;
import br.com.santander.services.GastoService;

@RestController
@RequestMapping("/gastos")
public class GastoController {

	@Autowired
	private GastoService gastoService;
	
	@PostMapping
	public Gasto cadastrar(Gasto gasto) {
		return gastoService.cadastrar(gasto);
	}
}
