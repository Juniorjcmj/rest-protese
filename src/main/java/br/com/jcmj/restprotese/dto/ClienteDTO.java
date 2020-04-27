package br.com.jcmj.restprotese.dto;

import br.com.jcmj.restprotese.model.Cliente;
import br.com.jcmj.restprotese.validadores.ClienteDTOPesquisa;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;



@ClienteDTOPesquisa
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@NotBlank(message="Nome é obrigatório")
	private String nome;
	@NotBlank(message="status é obrigatório")
	private String status;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataInicio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataFim;
	
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

    public ClienteDTO(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
