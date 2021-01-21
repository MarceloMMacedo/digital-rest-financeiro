package br.com.apirestfinanceiro.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.apifinanceiro.domain.estoque.Patrimonio;
import br.com.apifinanceiro.domain.financeiro.contrato.Contrato;
import br.com.apifinanceiro.domain.financeiro.movimento.MovimentoContrato;
import br.com.apifinanceiro.dto.BaseDto;
import br.com.apifinanceiro.services.ContratoService;
import br.com.apifinanceiro.services.ServiceImpl;
import br.com.apirestfinanceiro.util.services.FilesService;

@Controller
@RequestMapping(value = "/contratos")
public class ContratoController extends ControllerImp<Contrato> {

	private static final long serialVersionUID = 1L;

	@Autowired
	FilesService filesService;
	@Autowired
	ContratoService service;

	@Override
	public ServiceImpl<Contrato> service() {
		return service;
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> insert(@Validated @RequestBody Contrato objDto) {
		objDto.setId(null);
		String file = filesService._uploadProfilePicturefile("contrato.pdf", "");
		objDto.setImageContrato(file);
		try {
			System.out.println(filesService.downloadFile(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objDto = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDto.getId()).toUri();
		return ResponseEntity.created(uri).body(objDto.getId());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/{id}/picture", method = RequestMethod.POST)
	public ResponseEntity<String> uploadProfilePicture(@RequestParam(name = "file") MultipartFile file,
			@PathVariable Integer id) throws IOException {
		String s = service().uploadProfilePicture(file, id, "imageContrato");
		return ResponseEntity.ok().body(s);

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/baseall", method = RequestMethod.GET)
	public ResponseEntity<List<BaseDto>> findBaseAll() {
		List<BaseDto> baseDto = new ArrayList<>();
		baseDto = service.findBaseAll();
		return ResponseEntity.ok().body(baseDto);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/patrimonios", method = RequestMethod.GET)
	public ResponseEntity<List<Patrimonio>> patrimonios() {
		List<Patrimonio> patrimonios = new ArrayList<>();
		patrimonios = service.equipamentos();
		return ResponseEntity.ok().body(patrimonios);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/{id}/deleteequipamento", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteEquipamento(id);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/{id}/{idcliente}/{idgrupofinanceiro}/regerarparcelas", method = RequestMethod.GET)
	public ResponseEntity<Contrato> regerarparcelas(@PathVariable Integer id, @PathVariable Integer idcliente,
			@PathVariable Integer idgrupofinanceiro) {

		service.gerarparcelascontrato(id, idcliente, idgrupofinanceiro);
		Contrato contrato = service.find(id);
		return ResponseEntity.ok().body(contrato);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMG' , 'ROLE_OPF' , 'ROLE_ADMEST'  )")
	@RequestMapping(value = "/{id}/movimentocontrato", method = RequestMethod.GET)
	public ResponseEntity<MovimentoContrato> movimentocontrato(@PathVariable Integer id) {

		MovimentoContrato movimentoContrato = service.findMovimentoContrato(id);
		return ResponseEntity.ok().body(movimentoContrato);
	}
}
