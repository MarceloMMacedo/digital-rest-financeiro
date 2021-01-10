package br.com.core.apifinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.core.apifinanceiro.services.HistoricoPadraoSaidaService;
import br.com.core.apifinanceiro.services.ServiceImpl;
import br.com.core.dbcore.domain.financeiro.HistoricoPadraoSaida;

@RestController
@RequestMapping(value = "/historicopadraosaidas")
public class HistoricoPadraoSaidaController extends ControllerImp<HistoricoPadraoSaida> {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	HistoricoPadraoSaidaService service;

	@Override
	public ServiceImpl<HistoricoPadraoSaida> service() {
		return service;
	}
}
