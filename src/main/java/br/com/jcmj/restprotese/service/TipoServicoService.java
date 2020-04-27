package br.com.jcmj.restprotese.service;
import br.com.jcmj.restprotese.exceptions.DataIntegrityException;
import br.com.jcmj.restprotese.exceptions.ObjectNotFoundException;
import br.com.jcmj.restprotese.model.TipoServico;
import br.com.jcmj.restprotese.repository.TipoServicos;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TipoServicoService {

    @Autowired
    private TipoServicos repo;
    
    public TipoServico find(Integer id) {
        Optional<TipoServico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!:" + id + ", Tipo : " + TipoServico.class.getName()));
    }
    public TipoServico findNativo(Integer id) {
        System.out.println("entrouuuuu");
        TipoServico obj = repo.findByIdNativo(id);
        return obj;
    }
    @Transactional
    public TipoServico insert(TipoServico obj) {
        obj = repo.save(obj);
        return obj;
    }

    public TipoServico update(TipoServico obj) {       
        repo.save(obj);        
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

    public List<TipoServico> findAll() {
        List<TipoServico> list = repo.findAll();
        return list;
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
