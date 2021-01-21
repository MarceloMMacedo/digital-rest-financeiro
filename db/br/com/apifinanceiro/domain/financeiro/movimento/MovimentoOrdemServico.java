package br.com.apifinanceiro.domain.financeiro.movimento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.apidigitalfinanceiro.enums.StatusActiv;
import br.com.apidigitalfinanceiro.enums.TipoMovimentoEnum;
import br.com.apifinanceiro.domain.financeiro.GrupoFinanceiro;
import br.com.apifinanceiro.domain.financeiro.HistoricoPadraoSaida;
import br.com.apifinanceiro.domain.intefaces.BaseEntity;
import br.com.apifinanceiro.domain.ordemservico.OrdemServico;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor
@Getter
@Setter
public class MovimentoOrdemServico extends MovimentoFinanceiro implements BaseEntity, Serializable {
	

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(columnDefinition = " int")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private OrdemServico os;
	
	public MovimentoOrdemServico(String tipomovimento) {
		super(tipomovimento);
	}

	public MovimentoOrdemServico(int id,int parcelas) {
		super(id, parcelas);
	}

	
	public MovimentoOrdemServico(int parcelas, OrdemServico os, double valor) {
		super(); 
		setName("Ordem Serviço - " + String.valueOf(os.getId()));
		setParcela(1);
		this.os=os;
		setTipomovimento(TipoMovimentoEnum.EntradaOrdemServico.getDescricao());
		setStatus(StatusActiv.ABERTO.getDescricao());
		setDataVencimento(new Date());
		setValor(valor);
	}
}
