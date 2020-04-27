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
    public Servico insert(ServicoDTO dto) {
       Servico obj =  TranformacaoDtoEObj.transformaServicoDTOemServico(dto);
        obj = repo.save(obj);
        return obj;
    }


    public Servico update(ServicoDTO dto) {
        Servico obj =  TranformacaoDtoEObj.transformaServicoDTOemServico(dto);
        obj = repo.save(obj);
        return obj;       
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
            ServicoDTO dto = TranformacaoDtoEObj.transformandoServicoEmServicoDTO(servico);
            listDTO.add(dto);            
        }
        return listDTO;
    }

    public List<ServicoDTO> findAllPorNome(String nome) {
        List<Servico> list = repo.findAllporNomePaciente(nome);
        List<ServicoDTO>listDTO = new ArrayList<>();
        for (Servico s : list) {
            listDTO.add(TranformacaoDtoEObj.transformandoServicoEmServicoDTO(s));
        }
        return listDTO;
    }

    public List<ServicoDTO> findAllPorOrdemServico(Integer id) {
        List<Servico> list = repo.findAllporOrdemServico(id);
        List<ServicoDTO>listDTO = new ArrayList<>();
        for (Servico s : list) {
            listDTO.add(TranformacaoDtoEObj.transformandoServicoEmServicoDTO(s));
        }
        return listDTO;
    }
//
//    public Cliente findByEmail(String email) {
//        UserSS user = UserService.authenticated();
//        if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
//            throw new AuthorizationException("Acesso Negado");
//        }
//
//        Cliente obj = repo.findByEmail(email);
//        if (obj == null) {
//            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + user.getId()
//                    + ", Tipo: " + Cliente.class.getName());
//        }
//        return obj;
//    }
//
//    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//        return repo.findAll(pageRequest);
//    }
//
//    /**
//     * METODO AUXILIAR QUE INSTANCIA UMA CATEGORIA A PARTIR DE UM OBJETO DTO
//     *
//     * @param objDto
//     * @return
//     */
//    public Cliente fromDTO(ClienteDTO objDto) {
//
//        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
//
//    }
//
//    public Cliente fromDTO(ClienteNewDTO objDTO) {
//        Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfOuCnpj(), TipoCliente.toEnum(objDTO.getTipo()), pe.encode(objDTO.getSenha()));
//        Cidade cid = repoCid.getOne(objDTO.getCidadeId());
//        Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getNumero(), objDTO.getBairro(), objDTO.getCep(), cli, cid);
//        cli.getEnderecos().add(end);
//        cli.getTelefones().add(objDTO.getTelefone1());
//        if (objDTO.getTelefone2() != null) {
//            cli.getTelefones().add(objDTO.getTelefone2());
//        }
//        if (objDTO.getTelefone3() != null) {
//            cli.getTelefones().add(objDTO.getTelefone3());
//        }
//        return cli;
//    }
//
//    public URI uploadProfilePicture(MultipartFile multipartifile) {
//        UserSS user = UserService.authenticated();
//        if (user == null) {
//            throw new AuthorizationException("Acesso negado");
//        }
//
//        BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartifile);
//        String fileName = prefix + user.getId() + ".jpg";
//
//        return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
//
//    }
//
//    @Transactional
//    public void novoEndereco(EnderecoDTO obendDTOj) {
//
//        UserSS user = UserService.authenticated();
//        if (user == null) {
//            throw new AuthorizationException("Acesso negado");
//        }
//        Cliente obj = find(user.getId());
//        Endereco e = new Endereco(null, obendDTOj.getLogradouro(), obendDTOj.getNumero(), obendDTOj.getComplemento(), obendDTOj.getBairro(), null, obj, null);
//        obj.getEnderecos().add(e);
//        repoEnd.saveAll(obj.getEnderecos());
//    }
//
//    public Endereco findEndereco(Integer id) {
//        Endereco end = repoEnd.peloId(id);
//        return end;
//    }

}
