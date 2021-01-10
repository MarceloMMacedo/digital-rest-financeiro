package br.com.core.apifinanceiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.core.dbcore.domain.financeiro.GrupoFinanceiroAnuncio;

@Repository
public interface GrupoFinanceiroAnuncioRepository extends JpaRepository<GrupoFinanceiroAnuncio, Integer> {

}
