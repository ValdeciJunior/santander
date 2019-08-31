package br.com.santander.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.santander.entities.Gasto;
import br.com.santander.repositories.GastoRepository;

@Service
public class GastoService {

	@Autowired
	private GastoRepository gastoRepository;
	
	public Gasto cadastrar(Gasto gasto) {
		gasto.setCodigousuario(1);
		return gastoRepository.save(gasto);
	}
}
