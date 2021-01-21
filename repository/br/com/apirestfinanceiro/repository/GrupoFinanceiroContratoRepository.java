package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.GrupoFinanceiroContrato;

@Repository
public interface GrupoFinanceiroContratoRepository extends JpaRepository<GrupoFinanceiroContrato, Integer> {

}
