package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.ContasBanco;

@Repository
public interface ContasBancoRepository extends JpaRepository<ContasBanco, Integer> {

}
