package br.com.core.apifinanceiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.core.dbcore.domain.pessoas.ContacFornecedores;

@Repository
public interface ContactFornecedoresRepository extends JpaRepository<ContacFornecedores, Integer> {

}