package br.com.core.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.ClientesRepository;
import br.com.core.apifinanceiro.ContactClientesRepository;
import br.com.core.apifinanceiro.EnderecoClientesRepository;
import br.com.core.dbcore.domain.pessoas.Clientes;
import br.com.core.dbcore.domain.pessoas.ContacClientes;
import br.com.core.dbcore.domain.pessoas.EnderecoClientes;

@Service
public class ClientesService
		extends PessoaBaseService<Clientes, ContacClientes, EnderecoClientes, Clientes> {

	private static final long serialVersionUID = 1L;

	@Autowired
	ClientesRepository repo;

	@Autowired
	EnderecoClientesRepository enderecoEmpreRepository;

	@Autowired
	ContactClientesRepository contactEmpreRepository;

	@Override
	public JpaRepository<Clientes, Integer> repo() {
		return repo;
	}

	@Override
	public JpaRepository<Clientes, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public JpaRepository<ContacClientes, Integer> getRepoContact() {
		// TODO Auto-generated method stub
		return contactEmpreRepository;
	}

	@Override
	public JpaRepository<EnderecoClientes, Integer> getRepoEnd() {
		// TODO Auto-generated method stub
		return enderecoEmpreRepository;
	}

}
