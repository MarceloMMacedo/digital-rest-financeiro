package br.com.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.apifinanceiro.domain.pessoas.ContacFuncionarios;
import br.com.apifinanceiro.domain.pessoas.EnderecoFuncionarios;
import br.com.apifinanceiro.domain.pessoas.Funcionarios;
import br.com.apirestfinanceiro.repository.ContactFuncioRepository;
import br.com.apirestfinanceiro.repository.EnderecoFuncRepository;
import br.com.apirestfinanceiro.repository.FuncionariosRepository;

@Service
public class FuncionariosService
		extends PessoaBaseService<Funcionarios, ContacFuncionarios, EnderecoFuncionarios, Funcionarios> {

	private static final long serialVersionUID = 1L;

	@Autowired
	FuncionariosRepository repo;

	@Autowired
	EnderecoFuncRepository enderecoEmpreRepository;

	@Autowired
	ContactFuncioRepository contactEmpreRepository;

	@Override
	public JpaRepository<Funcionarios, Integer> repo() {
		return repo;
	}

	@Override
	public JpaRepository<Funcionarios, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public JpaRepository<ContacFuncionarios, Integer> getRepoContact() {
		// TODO Auto-generated method stub
		return contactEmpreRepository;
	}

	@Override
	public JpaRepository<EnderecoFuncionarios, Integer> getRepoEnd() {
		// TODO Auto-generated method stub
		return enderecoEmpreRepository;
	}

}
