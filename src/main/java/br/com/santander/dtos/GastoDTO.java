package br.com.santander.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GastoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String uuid;

	private String descricao;
	
	private BigDecimal valor;
	
	private Date data;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

}
