package br.com.jcmj.restprotese.resources;

import br.com.jcmj.restprotese.dto.ServicoDTO;
import br.com.jcmj.restprotese.dto.ServicoProteticoDTO;
import br.com.jcmj.restprotese.model.Servico;
import br.com.jcmj.restprotese.model.ServicoProtetico;
import br.com.jcmj.restprotese.service.ServicoProteticoService;
import br.com.jcmj.restprotese.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/servicosProteticos")
public class ServicoProteticoResource {
       
    @Autowired
    private ServicoProteticoService service;
    
    @RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<ServicoProteticoDTO> findDTO(@PathVariable Integer id)  {
		ServicoProtetico obj = service.find(id);
                ServicoProteticoDTO dto = service.transformandoServicoEmServicoDTO(obj);
		return ResponseEntity.ok().body(dto) ;
	}
	@RequestMapping(value= "obj/{id}",method=RequestMethod.GET)
	public ResponseEntity<ServicoProtetico> find(@PathVariable Integer id)  {
		ServicoProtetico obj = service.find(id);
		return ResponseEntity.ok().body(obj) ;
	}
//        @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ServicoProteticoDTO>> findAll()  {
		List<ServicoProteticoDTO> list = service.findAll();
                if(list.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }else{
                    return new ResponseEntity<List<ServicoProteticoDTO>>(list, HttpStatus.OK);
                }		
	}
	@RequestMapping(value= "por/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<ServicoProtetico>> findAllPorId(@PathVariable Integer id)  {
		List<ServicoProtetico> list = service.findAllPorID(id);
		if(list.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<List<ServicoProtetico>>(list, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody @Valid ServicoProteticoDTO obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).build();		
	}
	@RequestMapping(value= "/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void>update(@RequestBody @Valid ServicoProteticoDTO obj, @PathVariable Integer id){
    	service.update(obj);
		return ResponseEntity.noContent().build();		
	}
        @RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<ServicoProtetico> delete(@PathVariable Integer id)  {
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
