package br.com.core.apifinanceiro.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.core.apifinanceiro.dto.ResumoMovimentoFinaneiro;
import br.com.core.apifinanceiro.services.ReporMovimentoFinanceiroService;


@Controller
@RequestMapping(value = "/repormovimentofinanceiro")
public class ReporMovimentoFinanceiroController implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ReporMovimentoFinanceiroService service;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<ResumoMovimentoFinaneiro> resumoexercicios() { 
		return ResponseEntity.ok(service.resumoexercicios());
	}
 

}
