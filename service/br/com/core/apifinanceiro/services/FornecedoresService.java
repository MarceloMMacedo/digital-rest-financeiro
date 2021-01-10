package br.com.core.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.ContactFornecedoresRepository;
import br.com.core.apifinanceiro.EnderecoFornecedoresRepository;
import br.com.core.apifinanceiro.FornecedoresRepository;
import br.com.core.dbcore.domain.pessoas.ContacFornecedores;
import br.com.core.dbcore.domain.pessoas.EnderecoFornecedores;
import br.com.core.dbcore.domain.pessoas.Fornecedores;

@Service
public class FornecedoresService
		extends PessoaBaseService<Fornecedores, ContacFornecedores, EnderecoFornecedores, Fornecedores> {

	private static final long serialVersionUID = 1L;

	@Autowired
	FornecedoresRepository repo;

	@Autowired
	EnderecoFornecedoresRepository enderecoEmpreRepository;

	@Autowired
	ContactFornecedoresRepository contactEmpreRepository;

	@Override
	public JpaRepository<Fornecedores, Integer> repo() {
		return repo;
	}

	@Override
	public JpaRepository<Fornecedores, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public JpaRepository<ContacFornecedores, Integer> getRepoContact() {
		// TODO Auto-generated method stub
		return contactEmpreRepository;
	}

	@Override
	public JpaRepository<EnderecoFornecedores, Integer> getRepoEnd() {
		// TODO Auto-generated method stub
		return enderecoEmpreRepository;
	}

}
