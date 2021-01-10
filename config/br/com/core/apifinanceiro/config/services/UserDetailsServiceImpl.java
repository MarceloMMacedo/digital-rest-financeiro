package br.com.core.apifinanceiro.config.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.FuncionariosRepository;
import br.com.core.apifinanceiro.security.UserSS;
import br.com.core.dbcore.StatusActiv;
import br.com.core.dbcore.domain.pessoas.Funcionarios;
 

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private FuncionariosRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 
		Funcionarios cli = repo.findByEmailAndStatus(email,  StatusActiv.ATIVO.getDescricao() );
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
	//	System.out.println(cli.getRolers());
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(),cli.getEmpresa(),cli.getRolers() );
	}
}
