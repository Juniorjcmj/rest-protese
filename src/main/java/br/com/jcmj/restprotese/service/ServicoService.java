package br.com.jcmj.restprotese.service;

import br.com.jcmj.restprotese.dto.ClienteDTO;
import br.com.jcmj.restprotese.dto.ServicoDTO;
import br.com.jcmj.restprotese.exceptions.DataIntegrityException;
import br.com.jcmj.restprotese.exceptions.ObjectNotFoundException;
import br.com.jcmj.restprotese.model.Cliente;
import br.com.jcmj.restprotese.model.Servico;
import br.com.jcmj.restprotese.model.TipoServico;
import br.com.jcmj.restprotese.repository.Clientes;
import br.com.jcmj.restprotese.repository.Servicos;
import br.com.jcmj.restprotese.repository.TipoServicos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.jcmj.restprotese.utilitario.TranformacaoDtoEObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoService {
    @Autowired
    private ClienteService clienteservice;
    @Autowired
    private Servicos repo;
    @Autowired
    private TipoServicoService tipoServicoService;

    

    public Servico find(Integer id) {
        Optional<Servico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!:" + id + ", Tipo : " + Servico.class.getName()));
    }
    @Transactional
    public Servico insert(ServicoDTO obj) {
       Servico s =  transformaServicoDTOemServico(obj);
        return repo.save(s);
    }
    public Servico update(ServicoDTO obj) {
        Servico s =  transformaServicoDTOemServico(obj);
        return repo.save(s);
    }
    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas");
        }
    }
    public List<ServicoDTO> findAll() {
        List<Servico> list = repo.findAll();
        List<ServicoDTO> listDTO = new ArrayList<>();
        for (Servico servico : list) {
            ServicoDTO dto = transformandoServicoEmServicoDTO(servico);
            listDTO.add(dto);            
        }
        return listDTO;
    }

    public List<ServicoDTO> findAllPorNome(String nome) {
        List<Servico> list = repo.findAllporNomePaciente(nome);
        List<ServicoDTO>listDTO = new ArrayList<>();
        for (Servico s : list) {
            listDTO.add(transformandoServicoEmServicoDTO(s));
        }
        return listDTO;
    }

    public List<ServicoDTO> findAllPorOrdemServico(Integer id) {
        List<Servico> list = repo.findAllporOrdemServico(id);
        List<ServicoDTO>listDTO = new ArrayList<>();
        for (Servico s : list) {
            listDTO.add(transformandoServicoEmServicoDTO(s));
        }
        return listDTO;
    }


    public  Servico transformaServicoDTOemServico(ServicoDTO dto){
        Cliente cliente = clienteservice.find(dto.getClienteId());
        TipoServico tipo = tipoServicoService.findNativo(dto.getTipoServicoId());

        if(tipo == null){
            dto.setValorServico((tipo.getPreco() - (tipo.getPreco() * dto.getValorDesconto())/100)* dto.getQuantidade());
        }
        Servico obj = new Servico(dto.getId(), dto.getValorServico(),
                dto.getValorDesconto(), "teste", dto.getPaciente(),
                dto.getStatus(), dto.getStatusPagamento(), dto.getFormaPagamento(),
                dto.getObservacao(), new Date(), dto.getDataEntrega(),
                dto.getDataPagamento(), dto.getQuantidade());
        obj.setCliente(cliente);
        obj.setTipoServico(tipo);
        return obj;
    }

    public   ServicoDTO transformandoServicoEmServicoDTO( Servico servico){
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



}
