package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.pessoas.ContacFornecedores;

@Repository
public interface ContactFornecedoresRepository extends JpaRepository<ContacFornecedores, Integer> {

}
