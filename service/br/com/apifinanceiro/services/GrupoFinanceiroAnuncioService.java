package br.com.apifinanceiro.services;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.apifinanceiro.domain.financeiro.GrupoFinanceiroAnuncio;
import br.com.apirestfinanceiro.repository.GrupoFinanceiroAnuncioRepository;

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
