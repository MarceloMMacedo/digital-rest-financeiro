package br.com.apifinanceiro.config.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.apifinanceiro.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
