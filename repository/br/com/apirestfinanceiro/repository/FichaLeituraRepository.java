package br.com.apirestfinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.apifinanceiro.domain.financeiro.contrato.FichaLeitura;

public interface FichaLeituraRepository extends JpaRepository<FichaLeitura,Integer> {


	@Transactional(readOnly = true)
	List<FichaLeitura> findByContratoIdAndStatus(Integer id,String Status);

	@Transactional(readOnly = true)
	List<FichaLeitura> findAllByFaturaId(Integer id);
	
}
