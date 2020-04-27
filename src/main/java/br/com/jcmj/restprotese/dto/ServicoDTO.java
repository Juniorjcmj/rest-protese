package br.com.jcmj.restprotese.dto;

import java.util.Date;
import java.util.List;

import br.com.jcmj.restprotese.model.Cliente;
import br.com.jcmj.restprotese.model.TipoServico;

public class ServicoDTO {
		
	private Integer id;
        private Double valorServico;
         private Integer valorDesconto;
         private String cadastrante;
         private String statusPagamento;
         private String formaPagamento;
         private String observacao;
	private String paciente;
	private String status;	
	private Date dataEntrega;
        private Date dataCadastro;
        private Date dataPagamento;
	private Integer clienteId;	
	private Integer tipoServicoId;	
        private Integer quantidade;
	public ServicoDTO() {
		
	}
	

	public ServicoDTO(Integer id, Double valorServico, Integer valorDesconto, String cadastrante, String paciente,
			String status, String statusPagamento, String formaPagamento, String observacao, Date dataCadastro,
			Date dataEntrega, Date dataPagamento, Integer quantidade, Integer clienteId,
			Integer tipoServicoId) {
		super();
		this.id = id;
                this.valorServico = valorServico;
                this.quantidade =quantidade;
                this.dataPagamento = dataPagamento;
                this.dataCadastro = dataCadastro;
		this.paciente = paciente;
                this.observacao = observacao;
                this.formaPagamento =formaPagamento;
                this.statusPagamento = statusPagamento;
                this.cadastrante =cadastrante;
		this.status = status;
		this.dataEntrega = dataEntrega;
		this.clienteId = clienteId;
		this.tipoServicoId = tipoServicoId;
                this.valorDesconto = valorDesconto;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Integer getCliente() {
		return clienteId;
	}

	public void setCliente(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getTipoServico() {
		return tipoServicoId;
	}

	public void setTipoServico(Integer tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Integer getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Integer valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getCadastrante() {
        return cadastrante;
    }

    public void setCadastrante(String cadastrante) {
        this.cadastrante = cadastrante;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Integer getTipoServicoId() {
        return tipoServicoId;
    }

    public void setTipoServicoId(Integer tipoServicoId) {
        this.tipoServicoId = tipoServicoId;
    }
    
   

	
}
