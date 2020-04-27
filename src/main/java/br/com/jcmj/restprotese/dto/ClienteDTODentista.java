package br.com.jcmj.restprotese.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.jcmj.restprotese.validadores.ClienteDTODentistaV;

@ClienteDTODentistaV
public class ClienteDTODentista implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataInicio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataFim;
	private String status;
	
	public ClienteDTODentista() {
		// TODO Auto-generated constructor stub
	}
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
}
