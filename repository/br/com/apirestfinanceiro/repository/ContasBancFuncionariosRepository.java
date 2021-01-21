package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apifinanceiro.domain.pessoas.ContasBancFuncionarios;

public interface ContasBancFuncionariosRepository extends JpaRepository<ContasBancFuncionarios, Integer> {

}
