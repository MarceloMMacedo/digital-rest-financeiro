package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.CentroCusto;

@Repository
public interface CentroCustoRepository extends JpaRepository<CentroCusto, Integer> {

}
