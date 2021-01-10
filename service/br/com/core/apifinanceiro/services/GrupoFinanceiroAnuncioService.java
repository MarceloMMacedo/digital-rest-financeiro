package br.com.core.apifinanceiro.services;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.GrupoFinanceiroAnuncioRepository;
import br.com.core.dbcore.domain.financeiro.GrupoFinanceiroAnuncio;

@Service
public class GrupoFinanceiroAnuncioService  extends GrupoFinanceiroService<GrupoFinanceiroAnuncio>{

	private static final long serialVersionUID = 1L;

	@Autowired
	GrupoFinanceiroAnuncioRepository repo;

	@Override
	public JpaRepository<GrupoFinanceiroAnuncio, Integer> repo() {
		return repo;
	}

 
}
