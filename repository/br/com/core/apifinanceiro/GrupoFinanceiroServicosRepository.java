package br.com.core.apifinanceiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.core.dbcore.domain.financeiro.GrupoFinanceiroServicos;

@Repository
public interface GrupoFinanceiroServicosRepository extends JpaRepository<GrupoFinanceiroServicos, Integer> {

}
