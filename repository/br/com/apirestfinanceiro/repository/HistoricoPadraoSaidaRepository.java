package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.HistoricoPadraoSaida;

@Repository
public interface HistoricoPadraoSaidaRepository extends JpaRepository<HistoricoPadraoSaida, Integer> {

}
