package br.com.core.apifinanceiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.core.dbcore.domain.pessoas.Empresas;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Integer> {

	 
	@Transactional(readOnly=true)
	Empresas findByEmail(String email);
	
	@Transactional(readOnly=true)
	Empresas findByEmailAndStatus(String email, String status);
}
