package br.com.core.apifinanceiro.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.CentroCustoRepository;
import br.com.core.apifinanceiro.FaturaRepository;
import br.com.core.dbcore.NaturezaMovimentoEnum;
import br.com.core.dbcore.StatusActiv;
import br.com.core.dbcore.domain.financeiro.AgregadoFinanceiro;
import br.com.core.dbcore.domain.financeiro.CentroCusto;
import br.com.core.dbcore.domain.financeiro.movimento.Fatura;

@Service
public class CentroCustoService extends ServiceImpl<CentroCusto> {

	private static final long serialVersionUID = 1L;

	@Autowired
	CentroCustoRepository repo;

	@Autowired
	FaturaRepository faturaRepository;

	@Override
	public JpaRepository<CentroCusto, Integer> repo() {
		return repo;
	}

/*	@Override
	public List<CentroCusto> findAll() {
		List<CentroCusto> findAl = new LinkedList<>();
		findAl = super.findAll();

		for (CentroCusto centroCusto : findAl) {
			double v = 0;
			// saida
			try {
				Fatura f = faturaRepository.findByStatusAndNaturezamovimentoAndHistoricoCentrocustoId(
						StatusActiv.ABERTO.getDescricao(), NaturezaMovimentoEnum.Saida.getDescricao(),
						centroCusto.getId());
				v = centroCusto.getSaldoPagar() + f.getValor();
				centroCusto.setSaldoPagar(v);
			} catch (Exception e) {
				// TODO: handle exception
			}

			v = 0;
			// entrada
			try {
				Fatura f = faturaRepository.findByStatusAndNaturezamovimentoAndHistoricoCentrocustoId(
						StatusActiv.ABERTO.getDescricao(), NaturezaMovimentoEnum.Entrada.getDescricao(),
						centroCusto.getId());
				// v=f.getHistorico().getPercentual();
				v = centroCusto.getSaldoReceber() + f.getValor() * f.getHistorico().getPercentual() / 100;
				centroCusto.setSaldoDisponivel(centroCusto.getSaldo()- f.getValor() * f.getHistorico().getPercentual() / 100);
			} catch (Exception e) {
			}

			// loop agregadofinanceiro
			try {
				List<Fatura> f = faturaRepository
						.findAllByStatusAndNaturezamovimentoAndHistoricoAgregadofinanceirosCentrocustoId(
								StatusActiv.ABERTO.getDescricao(), NaturezaMovimentoEnum.Entrada.getDescricao(),
								centroCusto.getId());
				for (Fatura fatura : f) {
					for (AgregadoFinanceiro agregadoFinanceiro : fatura.getHistorico().getAgregadofinanceiros()) {
						if (agregadoFinanceiro.getCentrocusto().getId() == centroCusto.getId()) {
							v += agregadoFinanceiro.getPercentual() * fatura.getValor() / 100;
						}
					}

				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			centroCusto.setSaldoPagar(v);
		}

		return findAl;
	}

	@Override
	public CentroCusto find(Integer id) {
		CentroCusto centroCusto = super.find(id);
		double v = 0;
		// saida
		try {
			Fatura f = faturaRepository.findByStatusAndNaturezamovimentoAndHistoricoCentrocustoId(
					StatusActiv.ABERTO.getDescricao(), NaturezaMovimentoEnum.Saida.getDescricao(), centroCusto.getId());
			v = centroCusto.getSaldoPagar() + f.getValor();
			centroCusto.setSaldoPagar(v);
		} catch (Exception e) {
			// TODO: handle exception
		}

		v = 0;
		// entrada
		try {
			Fatura f = faturaRepository.findByStatusAndNaturezamovimentoAndHistoricoCentrocustoId(
					StatusActiv.ABERTO.getDescricao(), NaturezaMovimentoEnum.Entrada.getDescricao(),
					centroCusto.getId());
			// v=f.getHistorico().getPercentual();
			v = centroCusto.getSaldoReceber() + f.getValor() * f.getHistorico().getPercentual() / 100;
			centroCusto.setSaldoDisponivel(centroCusto.getSaldo()- f.getValor() * f.getHistorico().getPercentual() / 100);
		} catch (Exception e) {
		}

		// loop agregadofinanceiro
		try {
			List<Fatura> f = faturaRepository
					.findAllByStatusAndNaturezamovimentoAndHistoricoAgregadofinanceirosCentrocustoId(
							StatusActiv.ABERTO.getDescricao(), NaturezaMovimentoEnum.Entrada.getDescricao(),
							centroCusto.getId());
			for (Fatura fatura : f) {
				for (AgregadoFinanceiro agregadoFinanceiro : fatura.getHistorico().getAgregadofinanceiros()) {
					if (agregadoFinanceiro.getCentrocusto().getId() == centroCusto.getId()) {
						v += agregadoFinanceiro.getPercentual() * fatura.getValor() / 100;
					}
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		centroCusto.setSaldoReceber(v);
		
		return centroCusto;
	}*/
}
