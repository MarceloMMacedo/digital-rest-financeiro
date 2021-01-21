package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.GrupoFinanceiroAnuncio;

@Repository
public interface GrupoFinanceiroAnuncioRepository extends JpaRepository<GrupoFinanceiroAnuncio, Integer> {

}
