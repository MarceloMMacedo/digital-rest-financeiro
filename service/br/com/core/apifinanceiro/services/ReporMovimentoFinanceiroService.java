package br.com.core.apifinanceiro.services;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import br.com.apirestfinanceiro.util.services.FilesService;
import br.com.core.apifinanceiro.FaturaRepository;
import br.com.core.apifinanceiro.dto.ResumoMovimentoFinaneiro;
import br.com.core.apifinanceiro.dto.demonstrativo.DemosntrativoFinanceiroDto;
import br.com.core.apifinanceiro.dto.demonstrativo.ItemDemosntrativoFinanceiroDto;
import br.com.core.dbcore.TipoMovimentoEnum;
import net.sf.jasperreports.engine.JRException;

@Service
public class ReporMovimentoFinanceiroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	MovimentoSaidaServices saidaServices;

	@Autowired
	MovimentoContratoServices contratoServices;

	@Autowired
	FaturaRepository faturaRepository;

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	FilesService filesService;

	public ResumoMovimentoFinaneiro resumoexercicios() {
		ResumoMovimentoFinaneiro resumoMovimentoFinaneiros = new ResumoMovimentoFinaneiro();
		resumoMovimentoFinaneiros.setResumoPagar(saidaServices.resumocontaspagarsexercico());
		resumoMovimentoFinaneiros.setResumoReceberContrato(contratoServices.resumocontasrecebersexercico());
		resumoMovimentoFinaneiros.getEvents().addAll(saidaServices.createEvent());
		resumoMovimentoFinaneiros.getEvents().addAll(contratoServices.createEvent());
		return resumoMovimentoFinaneiros;
	}

	public DemosntrativoFinanceiroDto demonstrativoatual() {
		DemosntrativoFinanceiroDto demonstrativo = new DemosntrativoFinanceiroDto();
		// selecionar data
		int mes;
		int ano;
		SimpleDateFormat exercicio = new SimpleDateFormat("yyyy");
		ano = Integer.valueOf(exercicio.format(new Date()));
		SimpleDateFormat periodo = new SimpleDateFormat("MM");
		mes = Integer.valueOf(periodo.format(new Date()));

		// entradarealizados Resumo

		String tipomovimento_descricao = TipoMovimentoEnum.entradaContrato.getDescricao();
		int tipomovimento_id = TipoMovimentoEnum.entradaContrato.getId();

		List<Object[]> objects = new ArrayList<>();

		List<ItemDemosntrativoFinanceiroDto> entradas = new ArrayList<>();

		objects = faturaRepository.faturasdemosntrativofinanceiro(tipomovimento_id, ano, mes);
		for (Object[] obj : objects) {
			ItemDemosntrativoFinanceiroDto e = new ItemDemosntrativoFinanceiroDto(obj[0], obj[1], obj[2], obj[3],
					obj[4]);
			entradas.add(e);
		}

		// entradasarealizar a Realizar
		List<ItemDemosntrativoFinanceiroDto> movimentosaberto = new ArrayList<>();

		objects = faturaRepository.faturasItensdemosntrativofinanceiro(ano, mes);
		for (Object[] obj : objects) {
			ItemDemosntrativoFinanceiroDto e = new ItemDemosntrativoFinanceiroDto(obj[0], obj[1], obj[2], obj[3],
					obj[4],obj[5]);
			demonstrativo.getMovimentosAberto().add(e);
		}
		// Entrada OS Resumo

		tipomovimento_descricao = TipoMovimentoEnum.EntradaOrdemServico.getDescricao();
		tipomovimento_id = TipoMovimentoEnum.EntradaOrdemServico.getId();

		List<ItemDemosntrativoFinanceiroDto> entradarealizadosos = new ArrayList<>();
		objects = faturaRepository.faturasdemosntrativofinanceiro(tipomovimento_id, ano, mes);
		for (Object[] obj : objects) {
			ItemDemosntrativoFinanceiroDto e = new ItemDemosntrativoFinanceiroDto(obj[0], obj[1], obj[2], obj[3],
					obj[4]);
			entradarealizadosos.add(e);
		}
		for (ItemDemosntrativoFinanceiroDto itemDemosntrativoFinanceiroDto : entradarealizadosos) {
			entradas.add(itemDemosntrativoFinanceiroDto);
		}

		 

		// Saida Resumo

		tipomovimento_descricao = TipoMovimentoEnum.Saida.getDescricao();
		tipomovimento_id = TipoMovimentoEnum.Saida.getId();

		List<ItemDemosntrativoFinanceiroDto> saidas = new ArrayList<>();
		objects = faturaRepository.faturasdemosntrativofinanceiro(tipomovimento_id, ano, mes);
		for (Object[] obj : objects) {
			ItemDemosntrativoFinanceiroDto e = new ItemDemosntrativoFinanceiroDto(obj[0], obj[1], obj[2], obj[3],
					obj[4]);
			saidas.add(e);
		}
		// entradasarealizar a Realizar
		
		double realizados = 0;
		double futuros = 0;
		for (ItemDemosntrativoFinanceiroDto item : entradas) {
			realizados += item.getValorrealizado();
			futuros += item.getValorrealizar();
		}
		demonstrativo.setEstradasRealizadas(realizados);
		demonstrativo.setEstradasFuturas(futuros);

		realizados = 0;
		futuros = 0;
		for (ItemDemosntrativoFinanceiroDto item : saidas) {
			realizados += item.getValorrealizado();
			futuros += item.getValorrealizar();
		}
		demonstrativo.setSaidasRealizadas(realizados);
		demonstrativo.setSaidasFuturas(futuros);

		demonstrativo.setEntradarealizados(entradas); 

		demonstrativo.setSaidarealizados(saidas);
		 

		return demonstrativo;

	}

	public byte[] ViewPdf() throws JRException, IOException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String s = "";
		Resource res = resourceLoader.getResource("classpath:/templates/report/demonstrativofinanceiro/");
		try {
			s = res.getURI().getPath();
			System.out.println(res.getURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
		parameters.put("pathentrada", s + "/entradas.jasper");
		parameters.put("pathsaida", s + "/saidas.jasper");
		parameters.put("PathMovimento", s + "/movimentoaberto.jasper");

		List<?> source = new ArrayList<>();

		String templates = res.getURI().getPath() + "/demonstrativo.jrxml";
		List<DemosntrativoFinanceiroDto> list = new ArrayList<DemosntrativoFinanceiroDto>();
		list.add(demonstrativoatual());
		source = list;
		return filesService.ViewPdf(parameters, source, templates);
	}
}
