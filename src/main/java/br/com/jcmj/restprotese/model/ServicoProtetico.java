package br.com.jcmj.restprotese.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
public class ServicoProtetico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cadastrante;
    private String status;
    private String statusPagamento;
    private String formaPagamento;
    private String observacao;

    private Double comissao;
    private Double valor;

    private Integer quantidade;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataCadastro;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataEntrega;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataPagamento;


    @OneToOne
    @JoinColumn(name = "protetico_id")
    private Protetico protetico;


    @OneToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;


    @OneToOne
    @JoinColumn(name = "tipoServicoProtetico_id")
    private TipoServicoProtetico tipoServicoProtetico;

    public ServicoProtetico() {
    }



    public ServicoProtetico(Integer id, String cadastrante, String status, String statusPagamento,
                            String formaPagamento, String observacao, Double comissao, Double valor, Date dataCadastro,
                            Date dataEntrega, Date dataPagamento, Protetico protetico, Servico servico,
                            TipoServicoProtetico tipoServicoProtetico, Integer quantidade) {
        super();
        this.id = id;
        this.setQuantidade(quantidade);
        this.cadastrante = cadastrante;
        this.status = status;
        this.statusPagamento = statusPagamento;
        this.formaPagamento = formaPagamento;
        this.observacao = observacao;
        this.comissao = comissao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.dataEntrega = dataEntrega;
        this.dataPagamento = dataPagamento;
        this.protetico = protetico;
        this.servico = servico;
        this.tipoServicoProtetico = tipoServicoProtetico;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    public Protetico getProtetico() {
        return protetico;
    }

    public void setProtetico(Protetico protetico) {
        this.protetico = protetico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico( Servico servico) {
        this.servico = servico;

    }

    public TipoServicoProtetico getTipoServicoProtetico() {
        return tipoServicoProtetico;
    }

    public void setTipoServicoProtetico(TipoServicoProtetico tipoServicoProtetico) {
        this.tipoServicoProtetico = tipoServicoProtetico;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }



    public Integer getQuantidade() {
        return quantidade;
    }



    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String retornaValorFormatado(){
        String valorFormatado = valor.toString();

        return "R$" +valorFormatado +"  Reais";
    }

    @Override
    public String toString() {
        return " Dentista = "+ servico.getCliente().getNome()
                + ",  Paciente=" + servico.getPaciente()
                + ",  Servico=" + tipoServicoProtetico.getNome()
                + ",  valor=" + retornaValorFormatado()
                + "";
    }

    public String osNome() {

        return "OS : " +id  + "/ Tipo de Serviço :" + tipoServicoProtetico.getNome() + "/ QNTD :"+ quantidade;
    }

    public String fomatarDataCadastro() {

        DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String dataformatada = formatador.format(dataCadastro);
        return dataformatada;
    }
    public String fomatarDataEntrega() {

        DateFormat formatador = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String dataformatada = formatador.format(dataEntrega);
        return dataformatada;
    }
    public String valorFormatado() {

        return "R$"+ getValor().toString();
    }



}
