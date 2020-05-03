package br.com.jcmj.restprotese.resources;

import br.com.jcmj.restprotese.model.Cliente;
import br.com.jcmj.restprotese.service.ClienteService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping(value="/clientes")
public class ClienteResource {
       
    @Autowired
    private ClienteService service;


    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "retorna um cliente específico."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso!"),
			@ApiResponse(code = 500, message="Foi gerada uma exceção."),
	})
    @RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id)  {
		Cliente obj = service.find(id);			
		return ResponseEntity.ok().body(obj) ;
	}
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "retorna uma lista de clientes específico."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso!"),
			@ApiResponse(code = 500, message="Foi gerada uma exceção."),
	})
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll()  {
		List<Cliente> list = service.findAll();
                if(list.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }else{
                    return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
                }		
	}        
       
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody @Valid Cliente obj){
		obj = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).build();		
	}
        @RequestMapping(value= "/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void>update(@RequestBody @Valid Cliente obj, @PathVariable Integer id){
            
		//Cliente clienteO = service.find(id);
                service.update(obj);
		return ResponseEntity.noContent().build();		
	}
	@RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Cliente> delete(@PathVariable Integer id)  {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value= "pornomes/{nome}",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAllPorNome(@PathVariable String nome)  {

    	List<Cliente> list = service.findAllPorNome(nome);

		if(list.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
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
