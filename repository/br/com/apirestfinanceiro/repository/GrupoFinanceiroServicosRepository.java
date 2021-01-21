package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.GrupoFinanceiroServicos;

@Repository
public interface GrupoFinanceiroServicosRepository extends JpaRepository<GrupoFinanceiroServicos, Integer> {

}
