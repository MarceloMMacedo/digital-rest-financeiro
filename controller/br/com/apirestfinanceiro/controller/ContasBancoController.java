package br.com.apirestfinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.apifinanceiro.domain.financeiro.ContasBanco;
import br.com.apifinanceiro.services.ContasBancoService;
import br.com.apifinanceiro.services.ServiceImpl;

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
