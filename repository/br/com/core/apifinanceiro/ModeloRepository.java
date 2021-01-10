package br.com.core.apifinanceiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.core.dbcore.domain.estoque.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Integer> {

}
