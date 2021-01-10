package br.com.core.apifinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.core.apifinanceiro.services.CentroCustoService;
import br.com.core.apifinanceiro.services.ServiceImpl;
import br.com.core.dbcore.domain.financeiro.CentroCusto;

@Controller
@RequestMapping(value = "/centrocustos")
public class CentroCustoController extends ControllerImp<CentroCusto> {

	private static final long serialVersionUID = 1L;
	@Autowired
	CentroCustoService service;

	@Override
	public ServiceImpl<CentroCusto> service() {
		return service;
	}
}
