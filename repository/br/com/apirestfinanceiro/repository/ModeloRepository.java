package br.com.apirestfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apifinanceiro.domain.estoque.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Integer> {

}
