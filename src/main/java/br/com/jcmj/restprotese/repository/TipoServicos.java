package br.com.jcmj.restprotese.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcmj.restprotese.model.TipoServico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface TipoServicos extends JpaRepository<TipoServico, Integer>  {

    @Transactional(readOnly=true)
    @Query(value="select * from tipo_servico s where s.id =?1", nativeQuery=true)    
    TipoServico findByIdNativo(Integer id);
}
