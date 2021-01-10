package br.com.core.apifinanceiro.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.dto.ResumoMovimentoFinaneiro;

@Service
public class ReporMovimentoFinanceiroService implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Autowired
	MovimentoSaidaServices saidaServices;
	
	@Autowired
	MovimentoContratoServices contratoServices;
	
	public ResumoMovimentoFinaneiro resumoexercicios(){
		ResumoMovimentoFinaneiro resumoMovimentoFinaneiros=new ResumoMovimentoFinaneiro();
		resumoMovimentoFinaneiros.setResumoPagar(saidaServices.resumocontaspagarsexercico());
		resumoMovimentoFinaneiros.setResumoReceberContrato(contratoServices.resumocontasrecebersexercico());	
		resumoMovimentoFinaneiros.getEvents().addAll(saidaServices.createEvent());	
		resumoMovimentoFinaneiros.getEvents().addAll(contratoServices.createEvent());
		return resumoMovimentoFinaneiros;
	}
}
