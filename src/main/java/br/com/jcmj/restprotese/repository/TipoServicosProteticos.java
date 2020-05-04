package br.com.jcmj.restprotese.repository;

import br.com.jcmj.restprotese.model.TipoServico;
import br.com.jcmj.restprotese.model.TipoServicoProtetico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TipoServicosProteticos extends JpaRepository<TipoServicoProtetico, Integer>  {


}
