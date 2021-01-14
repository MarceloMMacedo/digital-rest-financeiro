package br.com.core.apifinanceiro.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.google.j2objc.annotations.AutoreleasePool;

import br.com.core.apifinanceiro.CentroCustoRepository;
import br.com.core.apifinanceiro.FaturaRepository;
import br.com.core.dbcore.NaturezaMovimentoEnum;
import br.com.core.dbcore.StatusActiv;
import br.com.core.dbcore.domain.financeiro.AgregadoFinanceiro;
import br.com.core.dbcore.domain.financeiro.CentroCusto;
import br.com.core.dbcore.domain.financeiro.movimento.Fatura;
import net.sf.jasperreports.engine.JRException;

@Service
public class CentroCustoService extends ServiceImpl<CentroCusto> {

	private static final long serialVersionUID = 1L;

	@Autowired
	CentroCustoRepository repo;

	@Autowired
	FaturaRepository faturaRepository;

	@Autowired
	CentroCustoRepository centroCustoRepository;

	@Autowired
	ResourceLoader resourceLoader;

	@Override
	public JpaRepository<CentroCusto, Integer> repo() {
		return repo;
	}

	@Override
	public byte[] ViewPdf() throws JRException, IOException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<?> source = new ArrayList<>();
		Resource res = resourceLoader.getResource("classpath:/templates/report/centrocusto/");
		String templates = res.getURI().getPath() + "/centrocusto.jrxml";
		source = centroCustoRepository.findAll();
		return filesService.ViewPdf(parameters, source, templates);
	}
}
