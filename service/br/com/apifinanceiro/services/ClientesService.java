package br.com.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.apifinanceiro.domain.pessoas.Clientes;
import br.com.apifinanceiro.domain.pessoas.ContacClientes;
import br.com.apifinanceiro.domain.pessoas.EnderecoClientes;
import br.com.apirestfinanceiro.repository.ClientesRepository;
import br.com.apirestfinanceiro.repository.ContactClientesRepository;
import br.com.apirestfinanceiro.repository.EnderecoClientesRepository;

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
