package br.com.jcmj.restprotese.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jcmj.restprotese.model.Cliente;

import java.util.List;

@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {
	@Transactional(readOnly=true)
	Cliente findByNome(String nome);
	
	@Transactional(readOnly=true)
	Cliente findByNomeStartingWith(String nome);
	
	@Transactional(readOnly=true)
	Cliente findByCpfCnpjStartingWith(String cpf);
	
	@Transactional(readOnly=true)
	Cliente findByEmailStartingWith(String email);
	@Transactional(readOnly=true)
	@Query(value = "SELECT * FROM CLIENTE WHERE NOME LIKE ?1%", nativeQuery = true)
    List<Cliente> findAllporNome(String nome);
}
