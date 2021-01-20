package br.com.core.dbcore.domain.financeiro.movimento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import br.com.core.dbcore.StatusActiv;
import br.com.core.dbcore.TipoMovimentoEnum;
import br.com.core.dbcore.domain.financeiro.HistoricoPadraoSaida;
import br.com.core.dbcore.domain.financeiro.contrato.Contrato;
import br.com.core.dbcore.domain.intefaces.BaseEntity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MovimentoSaida extends MovimentoFinanceiro implements BaseEntity, Serializable {

	private static final long serialVersionUID = 1L;

	public MovimentoSaida(String tipomovimento) {
		super(tipomovimento);
	}

	public MovimentoSaida(int id, int parcelas) {
		super(id, parcelas);
	}

	public MovimentoSaida(int parcelas, HistoricoPadraoSaida hs, double valor) {
		super();
		setHistorico(hs);
		setName(hs.getName());
		setParcela(parcelas);
		setTipomovimento(TipoMovimentoEnum.Saida.getDescricao());
		setStatus(StatusActiv.ABERTO.getDescricao());
		setDataVencimento(new Date());
		setValor(valor);
	}
}
