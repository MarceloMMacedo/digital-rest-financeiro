package br.com.core.apifinanceiro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.core.dbcore.domain.pessoas.Parceiros;

@Repository
public interface ParceirosRepository extends JpaRepository<Parceiros, Integer> {

	@Transactional(readOnly=true)
	Parceiros findByEmail(String email);

	@Transactional(readOnly=true)
	Parceiros findByEmailAndStatus(String email, String status);
	
	@Transactional(readOnly=true)
	List<Parceiros> findAllByEmpresaId(Integer id);
}
