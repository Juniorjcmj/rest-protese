package br.com.jcmj.restprotese.repository;

import br.com.jcmj.restprotese.model.Cliente;
import br.com.jcmj.restprotese.model.Servico;
import br.com.jcmj.restprotese.model.ServicoProtetico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
public interface ServicosProteticos extends JpaRepository<ServicoProtetico, Integer>  {



	@Transactional(readOnly=true)
	@Query(value="select * from servico_protetico s where s.servico_id =?1", nativeQuery=true)
	List<ServicoProtetico> buscarTodosSPdaOs(Integer id);

	/*
	@Transactional(readOnly=true)
	List<Servico> findByClienteStartingWithAndStatus(Cliente objDTO, String Status);

	@Transactional(readOnly=true)
	@Query(value = "SELECT * FROM SERVICO WHERE PACIENTE LIKE ?1%", nativeQuery = true)
	List<Servico> findAllporNomePaciente(String nome);
	@Transactional(readOnly=true)
	@Query(value = "SELECT * FROM SERVICO WHERE ID LIKE ?1%", nativeQuery = true)
	List<Servico> findAllporOrdemServico(Integer id);



	//buscando serviço pela data do cadastro e pelo ID
	@Transactional(readOnly=true)
	Servico findByCliente(Integer id);
	
	@Transactional(readOnly=true)
	List<Servico> findByStatusStartingWith(String status);
	
	//Servico findByNome(String nome);
	
	// Pesquisando por duas propriedades: nome e ativo.
	@Transactional(readOnly=true)
	 List<Servico> findByClienteAndStatusPagamentoAndStatus(Cliente cliente,String statusPagamento, String status);
	 
	 
	 
	// Buscar onde a data cadastro está dentro de um período.
	@Transactional(readOnly=true)
	 List<Servico> findByClienteAndDataCadastroBetween(Cliente cliente,Date inicio, Date fim);
	 
    //busca uma lista de serviços em um intervalo de datas
	@Transactional(readOnly=true)
	List<Servico> findByDataCadastroBetween(Date dataInicio, Date dataFim);

	@Transactional(readOnly=true)
	List<Servico> findByClienteAndStatusAndDataCadastroBetween(Cliente objCli, String status, Date dataInicio,
			Date dataFim);

	@Transactional(readOnly=true)
	List<Servico> findByStatusAndDataCadastroBetween(String status, Date dataInicio, Date dataFim);


	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status = 'AGUARDANDO' order by s.id desc", nativeQuery=true)
	List<Servico> findStatusAguardando();
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.data_entrega <=?1 and s.data_entrega >=?2 order by s.data_entrega asc", nativeQuery=true)
	List<Servico> findStatusAguardandoOrdeByDataTermino(Date dataFim, Date dataInicio);
	
	
	
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status = 'PROCESSANDO' order by s.id desc", nativeQuery=true)
	List<Servico> findStatusProcessando();
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status = 'TERMINADO' order by s.id desc", nativeQuery=true)
	List<Servico> findStatusTerminado();
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status = 'ARQUIVADO' order by s.id desc", nativeQuery=true)
	List<Servico> findStatusArquivado();
	@Transactional(readOnly=true)
	@Query(value="select * from servico s  order by s.id desc", nativeQuery=true)
	List<Servico> findTodosOrdenados();
	@Transactional(readOnly=true)
	@Query(value = "select * from servico s where s.cliente_id =?1", nativeQuery=true)
	List<Servico>buscaTodosPeloCliente(Integer id);
	@Transactional(readOnly=true)
	@Query(value = "select * from servico s where s.tipo_servico_id =?1", nativeQuery=true)
	List<Servico> buscaTodosPeloTipoServico(Integer id);
	@Transactional(readOnly=true)
	List<Servico> findByPacienteStartingWith(String paciente); 
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status =?1 and s.status_pagamento =?2 order by s.id desc", nativeQuery=true)
	List<Servico> finStatusPagamentoAndStatus(String status, String statusPagamento);

	/*
	  * MÉTODOS CRIADOS PARA BUSCAR TODOS SERVIÇOS DE UM DETERMINADO CLIENTE 

	@Query(value="select * from servico s where s.status = 'AGUARDANDO' and s.cliente_id =?1 order by s.id desc ", nativeQuery=true)
	List<Servico> findStatusAguardando(Integer id);
	
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status = 'PROCESSANDO' and s.cliente_id =?1 order by s.id desc ", nativeQuery=true)
	List<Servico> findStatusProcessando(Integer id);
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status = 'TERMINADO' and s.cliente_id =?1 order by s.id desc LIMIT 100", nativeQuery=true)
	List<Servico> findStatusTerminado(Integer id);
	@Transactional(readOnly=true)
	@Query(value="select * from servico s where s.status = 'ARQUIVADO' and s.cliente_id =?1 order by s.id desc ", nativeQuery=true)
	List<Servico> findStatusArquivado(Integer id);
      */
    /*
	  * TERMINO MÉTODOS CRIADOS PARA BUSCAR TODOS SERVIÇOS DE UM DETERMINADO CLIENTE 
	  */

	
	

		   
    // Equivalente ao like, mas não precisamos nos preocupar com o sinal de percentual. 
    // Podemos usar também EndingWith, Containing.
   // List<Servico> findByNomeStartingWith(String nome);
   
    // Ordenando pelo nome.
    //List<Servico> findByNomeStartingWithOrderByNome(String nome);
   
    // Não levar em consideração a caixa.
   // List<Servico> findByNomeStartingWithIgnoreCase(String nome);
 
    // Pesquisando por duas propriedades: nome e ativo.
   // List<Servico> findByNomeStartingWithIgnoreCaseAndAtivoEquals(String nome, boolean ativo);
   
    // Nesse caso, precisamos usar o sinal de percentual em nossas consultas.
   // List<Servico> findByNomeLike(String nome);
   
    // Podemos usar também IsNotNull ou NotNull.
   // List<Servico> findByDescricaoIsNull(); 
   
    // Quando você quer negar o que passa no parâmetro
   // List<Servico> findByNomeNot(String nome);
   
    // Todos os produtos com os IDs passados no varargs. Poderia usar NotIn para negar os IDs.
   // List<Servico> findByIdIn(Long... ids);
   
    // Todos onde a propriedade ativo é true. Poderia ser falso, usando False.
    //List<Servico> findByAtivoTrue();
   
    // Buscar onde a data de cadastro é depois do parâmetro passado. 
    // Pode ser usado Before também.
    /////List<Servico> findByCadastroAfter(Date data);
   
    // Buscar onde a data cadastro está dentro de um período.
   // List<Servico> findByCadastroBetween(Date inicio, Date fim);
   
    // Todos com quantidade "menor que". Poderia ser usado
    // também LessThanEqual, GreaterThan, GreaterThanEqual.
    //List<Servico> findByQuantidadeLessThan(int quantidade);
	
	
}
