package br.com.jcmj.restprotese.resources;

import br.com.jcmj.restprotese.dto.ServicoDTO;
import br.com.jcmj.restprotese.model.Cliente;
import br.com.jcmj.restprotese.model.Servico;
import br.com.jcmj.restprotese.service.ClienteService;
import br.com.jcmj.restprotese.service.ServicoService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import br.com.jcmj.restprotese.utilitario.TranformacaoDtoEObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {
       
    @Autowired
    private ServicoService service;
    
    @RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<ServicoDTO> find(@PathVariable Integer id)  {
		Servico obj = service.find(id);	
                ServicoDTO dto = TranformacaoDtoEObj.transformandoServicoEmServicoDTO(obj);
		return ResponseEntity.ok().body(dto) ;
	}
//        @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ServicoDTO>> findAll()  {
		List<ServicoDTO> list = service.findAll();
                if(list.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }else{
                    return new ResponseEntity<List<ServicoDTO>>(list, HttpStatus.OK);
                }		
	}        
       
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody @Valid ServicoDTO dto){
		Servico obj = service.insert(dto);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).build();		
	}
        @RequestMapping(value= "/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void>update(@RequestBody @Valid ServicoDTO dto, @PathVariable Integer id){        
		
                service.update(dto);
		return ResponseEntity.noContent().build();		
	}
        @RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Servico> delete(@PathVariable Integer id)  {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value= "porpaciente/{nome}",method=RequestMethod.GET)
	public ResponseEntity<List<ServicoDTO>> findAllPorNome(@PathVariable String nome)  {

		List<ServicoDTO> list = service.findAllPorNome(nome);

		if(list.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<ServicoDTO>>(list, HttpStatus.OK);
		}
	}
	@RequestMapping(value= "porordemservico/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<ServicoDTO>> findAllPorOrdemDeServico(@PathVariable Integer id)  {

		List<ServicoDTO> list = service.findAllPorOrdemServico(id);

		if(list.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<ServicoDTO>>(list, HttpStatus.OK);
		}
	}
	
//	/**
//	 * ATUALIZAR CATEGORIA 
//	 */
//	@RequestMapping(value= "/{id}",method=RequestMethod.PUT)
//	public ResponseEntity<Void>update(@Valid@RequestBody ClienteDTO objDto,@PathVariable Integer id){
//		Cliente obj = service.fromDTO(objDto);
//		obj.setId(id);		
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//		
//	}
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
//	public ResponseEntity<Cliente> delete(@PathVariable Integer id)  {
//		service.delete(id);	
//		
//		return ResponseEntity.noContent().build();
//	}
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<ClienteDTO>> findAll()  {
//		List<Cliente> list = service.findAll();	
//		List<ClienteDTO> listDto =  list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
//		
//		return ResponseEntity.ok().body(listDto) ;
//	}
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@RequestMapping(value= "/page", method=RequestMethod.GET)
//	public ResponseEntity<Page<ClienteDTO>> findPage(
//		@RequestParam(value="page", defaultValue="0")	Integer page,
//		@RequestParam(value="linesPerPage", defaultValue="24")	Integer linesPerPage,
//		@RequestParam(value="orderby", defaultValue="nome")	String orderBy,
//		@RequestParam(value="direction", defaultValue="ASC")	String direction)  {
//		Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);	
//		Page<ClienteDTO> listDto =  list.map(obj -> new ClienteDTO(obj));
//		
//		return ResponseEntity.ok().body(listDto) ;
//	}
//	
//	@RequestMapping(value="/picture", method = RequestMethod.POST)
//	public ResponseEntity<Void>uploadProfilePicture(@RequestParam(name="file")MultipartFile file){
//		URI uri = service.uploadProfilePicture(file);		
//		return ResponseEntity.created(uri).build();
//		
//	}
//	@RequestMapping(value= "/endereco",method=RequestMethod.POST)
//	public ResponseEntity<EnderecoDTO> novoEndereco(@RequestBody EnderecoDTO obj)  {
//		service.novoEndereco(obj);		
//		return ResponseEntity.noContent().build();
//	}
//	@RequestMapping(value= "/buscaendereco/{id}",method=RequestMethod.GET)
//	public ResponseEntity<Endereco> findEndereco(@PathVariable Integer id)  {
//		Endereco obj = service.findEndereco(id);		
//		return ResponseEntity.ok().body(obj) ;
//	}
}
