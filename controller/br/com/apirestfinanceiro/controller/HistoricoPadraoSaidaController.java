package br.com.apirestfinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apifinanceiro.domain.financeiro.HistoricoPadraoSaida;
import br.com.apifinanceiro.services.HistoricoPadraoSaidaService;
import br.com.apifinanceiro.services.ServiceImpl;

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
