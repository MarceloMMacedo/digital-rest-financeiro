package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.apifinanceiro.domain.pessoas.Empresas;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Integer> {

	 
	@Transactional(readOnly=true)
	Empresas findByEmail(String email);
	
	@Transactional(readOnly=true)
	Empresas findByEmailAndStatus(String email, String status);
}
