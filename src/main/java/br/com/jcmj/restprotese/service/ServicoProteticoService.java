package br.com.jcmj.restprotese.service;

import br.com.jcmj.restprotese.dto.ServicoDTO;
import br.com.jcmj.restprotese.dto.ServicoProteticoDTO;
import br.com.jcmj.restprotese.exceptions.DataIntegrityException;
import br.com.jcmj.restprotese.exceptions.ObjectNotFoundException;
import br.com.jcmj.restprotese.model.*;
import br.com.jcmj.restprotese.repository.Servicos;
import br.com.jcmj.restprotese.repository.ServicosProteticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoProteticoService {
    @Autowired
    private ProteticoService proteticoService;
    @Autowired
    private ServicosProteticos repo;
    @Autowired
    private TipoServicoProteticoService tipoServicoService;
    @Autowired
    private ServicoService servicoService;

    

    public ServicoProtetico find(Integer id) {
        Optional<ServicoProtetico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!:" + id + ", Tipo : " + ServicoProtetico.class.getName()));
    }
    @Transactional
    public ServicoProtetico insert(ServicoProteticoDTO obj) {
       ServicoProtetico s =  transformaServicoDTOemServico(obj);
        return repo.save(s);
    }
    public ServicoProtetico update(ServicoProteticoDTO obj) {
        ServicoProtetico s =  transformaServicoDTOemServico(obj);
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
    public List<ServicoProteticoDTO> findAll() {
        List<ServicoProtetico> list = repo.findAll();
        List<ServicoProteticoDTO> listDTO = new ArrayList<>();
        for (ServicoProtetico servicoProtetico : list) {
            ServicoProteticoDTO dto = transformandoServicoEmServicoDTO(servicoProtetico);
            listDTO.add(dto);            
        }
        return listDTO;
    }
    public  ServicoProtetico transformaServicoDTOemServico(ServicoProteticoDTO dto){
        Protetico protetico = proteticoService.find(dto.getProteticoId());
        TipoServicoProtetico tipo = tipoServicoService.find(dto.getTipoServicoProteticoId());
        Servico servico = servicoService.find(dto.getServicoId());
        if(tipo == null){
            dto.setValor((tipo.getPreco()* dto.getQuantidade()));
        }
        ServicoProtetico obj = new ServicoProtetico();
        obj.setServico(servico);
        obj.setQuantidade(dto.getQuantidade());
        obj.setDataCadastro(new Date());
        obj.setDataEntrega(dto.getDataEntrega());
        obj.setObservacao(dto.getObservacao());
        obj.setStatus(dto.getStatus());
        obj.setId(dto.getId());
        obj.setProtetico(protetico);
        obj.setTipoServicoProtetico(tipo);
        return obj;
    }

    public   ServicoProteticoDTO transformandoServicoEmServicoDTO( ServicoProtetico obj){
        ServicoProteticoDTO dto = new ServicoProteticoDTO();
        dto.setId(obj.getId());
        //aqio
        dto.setProteticoId(obj.getProtetico().getId());
        dto.setTipoServicoProteticoId(obj.getTipoServicoProtetico().getId());
        dto.setCadastrante("");
        dto.setDataCadastro(obj.getDataCadastro());
        dto.setDataEntrega(obj.getDataEntrega());
        dto.setDataPagamento(obj.getDataPagamento());
        dto.setFormaPagamento(obj.getFormaPagamento());
        dto.setObservacao(obj.getObservacao());
        dto.setQuantidade(obj.getQuantidade());
        dto.setStatus(obj.getStatus());
        dto.setStatusPagamento(obj.getStatusPagamento());
        dto.setValor(obj.getValor());
        dto.setServicoId(obj.getServico().getId());

        return dto;
    }


    public List<ServicoProtetico> findAllPorID(Integer id) {
        List<ServicoProtetico>listObj = repo.buscarTodosSPdaOs(id);

        return listObj;
    }
}
