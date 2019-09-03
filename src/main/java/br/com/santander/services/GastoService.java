package br.com.santander.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.santander.dtos.GastoDTO;
import br.com.santander.entities.Gasto;
import br.com.santander.repositories.GastoRepository;

@Service
public class GastoService {

//	Integer codigoCliente = 1;
	
	@Autowired
	private UserDetailsServiceImpl userDetails;
	
	@Autowired
	private GastoRepository gastoRepository;
	
	public Gasto cadastrar(GastoDTO gastoDTO) {
		Gasto gasto = new Gasto();
		BeanUtils.copyProperties(gastoDTO, gasto, "uuid");
		gasto.setCodigousuario(userDetails.get().getCodigoUsuario());
		gasto.setCategoria(gastosPorDescricao(gasto.getDescricao()).get(0).getCategoria());
		if(gasto.getData() == null) {
			gasto.setData(new Date());
		}
		return gastoRepository.save(gasto);
	}
	
	public Gasto salve(Gasto gasto) {
		gasto.setCodigousuario(userDetails.get().getCodigoUsuario());
		return gastoRepository.save(gasto);
	}
	
	public List<GastoDTO> listar(){
		List<GastoDTO> gastosDTO = new ArrayList<>();
		List<Gasto> gastos = gastoRepository.findAllByCodigousuario(userDetails.get().getCodigoUsuario());
		gastos.forEach(g -> {
			GastoDTO gastoDTO = new GastoDTO();
			BeanUtils.copyProperties(g, gastoDTO);
			gastosDTO.add(gastoDTO);
		});
		return gastosDTO;
	}
	
	public List<GastoDTO> listarPorData(Date data){
		List<GastoDTO> gastosDTO = new ArrayList<>();
		List<Gasto> gastos = gastoRepository.findAllByDataAndCodigousuario(data, userDetails.get().getCodigoUsuario());
		gastos.forEach(g -> {
			GastoDTO gastoDTO = new GastoDTO();
			BeanUtils.copyProperties(g, gastoDTO);
			gastosDTO.add(gastoDTO);
		});
		return gastosDTO;
	}
	
	public GastoDTO getDTO(String uuid) {
		Optional<Gasto> gasto = gastoRepository.findByUuidAndCodigousuario(uuid, userDetails.get().getCodigoUsuario());
		GastoDTO gastoDTO = new GastoDTO();
		BeanUtils.copyProperties(gasto, gastoDTO);
		return gastoDTO;
	}
	
	public Gasto get(String uuid) {
		Optional<Gasto> gasto = gastoRepository.findByUuidAndCodigousuario(uuid, userDetails.get().getCodigoUsuario());
		return gasto.get();
	}
	
	public List<Gasto> gastosPorDescricao(String descricao){
		return gastoRepository.findAllByLikeDescricaoAndCodigousuario(descricao, userDetails.get().getCodigoUsuario());
	}
	
	public GastoDTO alterarCategoria(String categoria, String uuid) {
		Gasto gasto = get(uuid);
		gasto.setCategoria(categoria);
		GastoDTO gastoDTO = new GastoDTO();
		salve(gasto);
		BeanUtils.copyProperties(gasto, gastoDTO);
		return gastoDTO;
	}
	
	public List<String> pesquisarCategorias(String categoria){
		return gastoRepository.findCategoraiasByCodigousuarioAndLikeCategoria(userDetails.get().getCodigoUsuario(), categoria);
	}
}























