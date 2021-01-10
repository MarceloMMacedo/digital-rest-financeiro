package br.com.core.apifinanceiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.core.dbcore.domain.financeiro.HistoricoPadraoSaida;

@Repository
public interface HistoricoPadraoSaidaRepository extends JpaRepository<HistoricoPadraoSaida, Integer> {

}
