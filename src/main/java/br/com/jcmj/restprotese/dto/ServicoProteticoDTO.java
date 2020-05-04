package br.com.jcmj.restprotese.dto;

import br.com.jcmj.restprotese.model.Protetico;
import br.com.jcmj.restprotese.model.Servico;
import br.com.jcmj.restprotese.model.TipoServicoProtetico;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ServicoProteticoDTO {

        private static final long serialVersionUID = 1L;
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
        private Integer proteticoId;
        private Integer servicoId;
        private Integer tipoServicoProteticoId;

    public ServicoProteticoDTO() {
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

    public Integer getProteticoId() {
        return proteticoId;
    }

    public void setProteticoId(Integer proteticoId) {
        this.proteticoId = proteticoId;
    }

    public Integer getServicoId() {
        return servicoId;
    }

    public void setServicoId(Integer servicoId) {
        this.servicoId = servicoId;
    }

    public Integer getTipoServicoProteticoId() {
        return tipoServicoProteticoId;
    }

    public void setTipoServicoProteticoId(Integer tipoServicoProteticoId) {
        this.tipoServicoProteticoId = tipoServicoProteticoId;
    }
}
