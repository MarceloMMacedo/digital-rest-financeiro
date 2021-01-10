package br.com.core.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.HistoricoPadraoSaidaRepository;
import br.com.core.dbcore.domain.financeiro.HistoricoPadraoSaida;

@Service
public class HistoricoPadraoSaidaService extends ServiceImpl<HistoricoPadraoSaida> {

	private static final long serialVersionUID = 1L;

	@Autowired
	HistoricoPadraoSaidaRepository repo;

	@Override
	public JpaRepository<HistoricoPadraoSaida, Integer> repo() {
		return repo;
	}
	
}
