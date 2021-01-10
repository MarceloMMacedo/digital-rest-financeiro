package br.com.core.apifinanceiro;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.core.dbcore.domain.pessoas.ContasBancFuncionarios;

public interface ContasBancFuncionariosRepository extends JpaRepository<ContasBancFuncionarios, Integer> {

}
