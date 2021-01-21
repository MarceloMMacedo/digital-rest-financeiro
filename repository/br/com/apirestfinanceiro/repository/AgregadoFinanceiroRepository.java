package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.AgregadoFinanceiro;

@Repository
public interface AgregadoFinanceiroRepository extends JpaRepository<AgregadoFinanceiro, Integer> {

}
