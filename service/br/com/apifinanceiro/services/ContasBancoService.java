package br.com.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.apifinanceiro.domain.financeiro.ContasBanco;
import br.com.apirestfinanceiro.repository.ContasBancoRepository;

@Service
public class ContasBancoService extends ServiceImpl<ContasBanco> {
	 
	private static final long serialVersionUID = 1L;
	@Autowired
	ContasBancoRepository repo;
	
	@Override
	public JpaRepository<ContasBanco, Integer> repo() { 
		return repo;
	}
	 
}
