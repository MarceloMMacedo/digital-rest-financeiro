package br.com.core.apifinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.core.apifinanceiro.services.ContasBancoService;
import br.com.core.apifinanceiro.services.ServiceImpl;
import br.com.core.dbcore.domain.financeiro.ContasBanco;

@Controller
@RequestMapping(value = "/contasbanco")
public class ContasBancoController extends ControllerImp<ContasBanco> {

	private static final long serialVersionUID = 1L;
	@Autowired
	ContasBancoService service;

	@Override
	public ServiceImpl<ContasBanco> service() {
		return service;
	}
}
