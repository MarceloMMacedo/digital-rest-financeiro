package br.com.core.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.ContactParceirosRepository;
import br.com.core.apifinanceiro.EnderecoParceiroRepository;
import br.com.core.apifinanceiro.ParceirosRepository;
import br.com.core.dbcore.domain.pessoas.ContacParceiros;
import br.com.core.dbcore.domain.pessoas.EnderecoParceiros;
import br.com.core.dbcore.domain.pessoas.Parceiros;

@Service
public class ParceirosService
		extends PessoaBaseService<Parceiros, ContacParceiros, EnderecoParceiros, Parceiros> {

	private static final long serialVersionUID = 1L;

	@Autowired
	ParceirosRepository repo;

	@Autowired
	EnderecoParceiroRepository enderecoEmpreRepository;

	@Autowired
	ContactParceirosRepository contactEmpreRepository;

	@Override
	public JpaRepository<Parceiros, Integer> repo() {
		return repo;
	}

	@Override
	public JpaRepository<Parceiros, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public JpaRepository<ContacParceiros, Integer> getRepoContact() {
		// TODO Auto-generated method stub
		return contactEmpreRepository;
	}

	@Override
	public JpaRepository<EnderecoParceiros, Integer> getRepoEnd() {
		// TODO Auto-generated method stub
		return enderecoEmpreRepository;
	}

}
