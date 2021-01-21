package br.com.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.apifinanceiro.domain.financeiro.HistoricoPadraoSaida;
import br.com.apirestfinanceiro.repository.HistoricoPadraoSaidaRepository;

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
