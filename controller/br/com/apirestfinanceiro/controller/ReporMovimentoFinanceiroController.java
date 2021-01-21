package br.com.apirestfinanceiro.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.apifinanceiro.dto.ResumoMovimentoFinaneiro;
import br.com.apifinanceiro.dto.demonstrativo.DemosntrativoFinanceiroDto;
import br.com.apifinanceiro.dto.demonstrativo.ReportDemostrativoFinancerio;
import br.com.apifinanceiro.services.ReporMovimentoFinanceiroService;
import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping(value = "/repormovimentofinanceiro")
public class ReporMovimentoFinanceiroController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	ReporMovimentoFinanceiroService service;

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResumoMovimentoFinaneiro> resumoexercicios() {
		return ResponseEntity.ok(service.resumoexercicios());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/demonstrativoatual", method = RequestMethod.GET)
	public ResponseEntity<DemosntrativoFinanceiroDto> demonstrativoatual() {
		return ResponseEntity.ok(service.demonstrativoatual());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/reportdemostrativofinancerio", method = RequestMethod.GET)
	public ResponseEntity<List<ReportDemostrativoFinancerio>> reportdemostrativofinancerio() {
		return ResponseEntity.ok(service.reportdemostrativofinancerio());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/mostrativofinancerioexercicio", method = RequestMethod.GET)
	public ResponseEntity<List<ReportDemostrativoFinancerio>> mostrativofinancerioexercicio(
			@RequestParam(value = "name", defaultValue = "") int exercicio) {
		return ResponseEntity.ok(service.reportdemostrativofinancerio());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/mostrativofinancerioperiodo", method = RequestMethod.GET)
	public ResponseEntity<List<ReportDemostrativoFinancerio>> mostrativofinancerioperiodo(
			@RequestParam(value = "name", defaultValue = "") int exercicio,
			@RequestParam(value = "name", defaultValue = "") int periodo) {
		return ResponseEntity.ok(service.reportdemostrativofinancerio());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/printdemonstrativo", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewpdf() throws JRException, IOException {

		return ResponseEntity.ok(service.ViewPdf());
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/printdemonstrativoperiodo", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewpdf(	@RequestParam(value = "exercico", defaultValue = "") int ano,
			@RequestParam(value = "mes", defaultValue = "") int mes) throws JRException, IOException {

		return ResponseEntity.ok(service.ViewPdf(ano, mes));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/viewpddemonstrativosintetico", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewpddemonstrativosintetico() throws JRException, IOException {

		return ResponseEntity.ok(service.viewpddemonstrativosintetico());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/viewpddemonstrativosinteticoexercicio", method = RequestMethod.GET)

	public ResponseEntity<byte[]> viewpddemonstrativosintetico(
			@RequestParam(value = "exercico", defaultValue = "") int exercicio) throws JRException, IOException {

		return ResponseEntity.ok(service.viewpddemonstrativosintetico(exercicio));
	}

 
}
