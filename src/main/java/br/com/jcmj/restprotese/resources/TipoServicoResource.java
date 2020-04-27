package br.com.jcmj.restprotese.resources;

import br.com.jcmj.restprotese.model.TipoServico;
import br.com.jcmj.restprotese.repository.TipoServicos;
import br.com.jcmj.restprotese.service.TipoServicoService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
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
@RequestMapping(value="/tipos")
public class TipoServicoResource {
    
    @Autowired
    private TipoServicoService service;
    
    @RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<TipoServico> find(@PathVariable Integer id)  {
		TipoServico obj = service.find(id);			
		return ResponseEntity.ok().body(obj) ;
	}
//        @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TipoServico>> findAll()  {
		List<TipoServico> list = service.findAll();
                if(list.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }else{
                    return new ResponseEntity<List<TipoServico>>(list, HttpStatus.OK);
                }		
	}
        
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody @Valid TipoServico obj){
		obj = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).build();		
	}
        @RequestMapping(value= "/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void>update(@RequestBody @Valid TipoServico obj, @PathVariable Integer id){            
		
                service.update(obj);
		return ResponseEntity.noContent().build();		
	}
        
	@RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<TipoServico> delete(@PathVariable Integer id)  {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
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
