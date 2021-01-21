package br.com.apifinanceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.apifinanceiro.domain.pessoas.ContacParceiros;
import br.com.apifinanceiro.domain.pessoas.EnderecoParceiros;
import br.com.apifinanceiro.domain.pessoas.Parceiros;
import br.com.apirestfinanceiro.repository.ContactParceirosRepository;
import br.com.apirestfinanceiro.repository.EnderecoParceiroRepository;
import br.com.apirestfinanceiro.repository.ParceirosRepository;

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
