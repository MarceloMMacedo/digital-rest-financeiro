package br.com.core.apifinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.core.apifinanceiro.services.GrupoFinanceiroServicosService;
import br.com.core.apifinanceiro.services.ServiceImpl;
import br.com.core.dbcore.domain.financeiro.GrupoFinanceiroServicos;

@Controller
@RequestMapping(value = "/gruposervicos")
public class GrupoFinanceiroServicosController extends ControllerImp<GrupoFinanceiroServicos> {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	GrupoFinanceiroServicosService service;
	


	 @Override
	public ServiceImpl<GrupoFinanceiroServicos> service() { 
		return service;
	}
	 
	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value="/{id}/deleteagregado", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteAgregado(id);
		return ResponseEntity.noContent().build();
	}
}
