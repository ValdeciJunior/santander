package br.com.santander.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santander.entities.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, String> {

	
	
}
