package br.com.jcmj.restprotese.utilitario;

import br.com.jcmj.restprotese.dto.ServicoDTO;
import br.com.jcmj.restprotese.model.Cliente;
import br.com.jcmj.restprotese.model.Servico;
import br.com.jcmj.restprotese.model.TipoServico;
import br.com.jcmj.restprotese.repository.Servicos;
import br.com.jcmj.restprotese.service.ClienteService;
import br.com.jcmj.restprotese.service.TipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;

public abstract class TranformacaoDtoEObj {

    @Autowired
    private static ClienteService clienteservice;
    @Autowired
    private static Servicos repo;
    @Autowired
    private static  TipoServicoService tipoServicoService;


  /*  public static Servico transformaServicoDTOemServico(ServicoDTO dto){
        Cliente cliente = clienteservice.find(dto.getClienteId());
        TipoServico tipo = tipoServicoService.findNativo(dto.getTipoServicoId());
        double valorServicoCalculado = tipo.getPreco() - (tipo.getPreco() * dto.getValorDesconto())/100;
        Servico obj = new Servico(dto.getId(), dto.getValorServico(),
                dto.getValorDesconto(), "teste", dto.getPaciente(),
                dto.getStatus(), dto.getStatusPagamento(), dto.getFormaPagamento(),
                dto.getObservacao(), new Date(), dto.getDataEntrega(),
                dto.getDataPagamento(), dto.getQuantidade());
        obj.setCliente(cliente);
        obj.setTipoServico(tipo);
        return obj;
    }
*/
    /*
    public static  ServicoDTO transformandoServicoEmServicoDTO( Servico servico){
        ServicoDTO dto = new ServicoDTO();
        dto.setId(servico.getId());
        //aqio
        dto.setClienteId(servico.getCliente().getId());
        dto.setTipoServicoId(servico.getTipoServico().getId());
        dto.setCadastrante("");
        dto.setDataCadastro(servico.getDataCadastro());
        dto.setDataEntrega(servico.getDataEntrega());
        dto.setDataPagamento(servico.getDataPagamento());
        dto.setFormaPagamento(servico.getFormaPagamento());
        dto.setObservacao(servico.getObservacao());
        dto.setPaciente(servico.getPaciente());
        dto.setQuantidade(servico.getQuantidade());
        dto.setStatus(servico.getStatus());
        dto.setStatusPagamento(servico.getStatusPagamento());
        dto.setValorDesconto(servico.getValorDesconto());
        dto.setValorServico(servico.getValorServico());

        return dto;
    }

   */
}
