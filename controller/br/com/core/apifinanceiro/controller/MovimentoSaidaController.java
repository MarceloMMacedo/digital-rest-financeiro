package br.com.core.apifinanceiro.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.core.apifinanceiro.dto.Events;
import br.com.core.apifinanceiro.dto.FaturaDto;
import br.com.core.apifinanceiro.dto.MovimentoFinanceiroDto;
import br.com.core.apifinanceiro.dto.ResumoContasMovimento;
import br.com.core.apifinanceiro.services.MovimentoSaidaServices;
import br.com.core.apifinanceiro.services.ServiceImpl;
import br.com.core.dbcore.domain.financeiro.movimento.MovimentoSaida;

@RestController
@RequestMapping(value = "/movimentosaida")
public class MovimentoSaidaController extends ControllerImp<MovimentoSaida> {

	private static final long serialVersionUID = 1L;

	@Autowired
	MovimentoSaidaServices service;

	@Override
	public ServiceImpl<MovimentoSaida> service() {
		return service;
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/resumoContasPagar", method = RequestMethod.GET)
	public ResponseEntity<List<ResumoContasMovimento>> resumoContasMovimento(
			@RequestParam(value = "value", defaultValue = "0") Integer exercicio) {

		return ResponseEntity.ok().body(service.resumoContasMovimentos(exercicio));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/exercicios", method = RequestMethod.GET)
	public ResponseEntity<List<Integer>> exerciciosAbert() {

		return ResponseEntity.ok().body(service.exerciciosAbert());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/totalpagar", method = RequestMethod.GET)
	public ResponseEntity<Double> totalPagar() {
		return ResponseEntity.ok().body(service.totalPagar());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/resumocontaspagarsexercico", method = RequestMethod.GET)
	public ResponseEntity<List<ResumoContasMovimento>> resumocontaspagarsexercico() {
		return ResponseEntity.ok().body(service.resumocontaspagarsexercico());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Events>> events() {
		return ResponseEntity.ok().body(service.createEvent());
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/quitarfatura", method = RequestMethod.PUT)
	public ResponseEntity<Void> quitarfatura(@Validated @RequestBody FaturaDto objDto) {
		service.quitarFatura(objDto);

		return ResponseEntity.ok().build();
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/{id}/quitarfatura", method = RequestMethod.GET)
	public ResponseEntity<FaturaDto> quitarfatura(@PathVariable Integer id) {

		return ResponseEntity.ok(service.faturaDto(id));
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/{id}/picture", method = RequestMethod.POST)
	public ResponseEntity<String> uploadProfilePicture(@RequestParam(name = "file") MultipartFile file,
			@PathVariable Integer id) throws IOException {
		String s = service.uploadProfilePicture(file, id, "imagemfatura");
		return ResponseEntity.ok().body(s);

	}

	@Override
	public ResponseEntity<Integer> insert(MovimentoSaida objDto) {
		// TODO Auto-generated method stub
		return super.insert(objDto);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/{id}/editarMoviemnto", method = RequestMethod.GET)
	public ResponseEntity<MovimentoFinanceiroDto> editarMoviemnto(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.editarMoviemnto(id));
	}

}
