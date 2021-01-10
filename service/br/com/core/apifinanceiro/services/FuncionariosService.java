package br.com.core.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.ContactFuncioRepository;
import br.com.core.apifinanceiro.EnderecoFuncRepository;
import br.com.core.apifinanceiro.FuncionariosRepository;
import br.com.core.dbcore.domain.pessoas.ContacFuncionarios;
import br.com.core.dbcore.domain.pessoas.EnderecoFuncionarios;
import br.com.core.dbcore.domain.pessoas.Funcionarios;

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
