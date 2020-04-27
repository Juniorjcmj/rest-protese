package br.com.jcmj.restprotese.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.jcmj.restprotese.validadores.ServicoUpdate;
@ServicoUpdate
@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

	private Double valorServico;
	private Integer valorDesconto;
	private Integer quantidade;


	private String cadastrante;
	@NotBlank(message="Paciente é obrigatório")
	private String paciente;
	private String status;
	private String statusPagamento;
	private String formaPagamento;
	@Size(max=250, message = "A Observação não deve ter mais que 250 caracteres")
	private String observacao;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataCadastro;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataEntrega;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataPagamento;


	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@NotNull(message="Tipo de servico deve ser informado")
	@OneToOne
	@JoinColumn(name = "tipoServico_id")
	private TipoServico tipoServico;

	public Servico() {
		// TODO Auto-generated constructor stub
	}

	

	public Servico(Integer id, Double valorServico, Integer valorDesconto, String cadastrante, String paciente,
			String status, String statusPagamento, String formaPagamento, String observacao, Date dataCadastro,
			Date dataEntrega, Date dataPagamento, Integer quantidade) {
		super();
		this.id = id;
		this.valorServico = valorServico;
		this.valorDesconto = valorDesconto;
		this.cadastrante = cadastrante;
		this.paciente = paciente;
		this.status = status;
		this.statusPagamento = statusPagamento;
		this.formaPagamento = formaPagamento;
		this.observacao = observacao;
		this.dataCadastro = dataCadastro;
		this.dataEntrega = dataEntrega;
		this.dataPagamento = dataPagamento;
		this.quantidade = quantidade;
		
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}


	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getCadastrante() {
		return cadastrante;
	}

	public void setCadastrante(String cadastrante) {
		this.cadastrante = cadastrante;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Integer getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Integer valorDesconto) {
		this.valorDesconto = valorDesconto;
	}



	public Integer getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	@Override
	public String toString() {
		 
		return "R$"+ getValorServico().toString()+"0";
	}
	
	public String osNome() {
		
		return "OS : " +id  + "/ Tipo de Serviço :" + tipoServico.getNome() + "/ QNTD :"+ quantidade;
	}
	
	public String fomatarDataCadastro() {
			if(dataCadastro == null) {
				return "Data não Informada";
			}else {
				DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				String dataformatada = formatador.format(dataCadastro);
				return dataformatada;
			}
		
	}
	public String fomatarDataEntrega() {
		if(dataEntrega == null) {
			return "Data não informada";
		}else {
			DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			String dataformatada = formatador.format(dataEntrega);
			return dataformatada;
		}
		
	}
	public String valorFormatado() {
		
		return "R$"+ getValorServico().toString();
	}

	
}
