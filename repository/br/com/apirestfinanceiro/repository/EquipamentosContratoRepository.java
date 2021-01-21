package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.financeiro.contrato.EquipamentosContrato;

@Repository
public interface EquipamentosContratoRepository extends JpaRepository<EquipamentosContrato, Integer> {

}
