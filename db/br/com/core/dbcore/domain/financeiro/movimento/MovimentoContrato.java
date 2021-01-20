package br.com.core.dbcore.domain.financeiro.movimento;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.core.dbcore.domain.intefaces.BaseEntity;
import lombok.NoArgsConstructor;

@Entity 
@NoArgsConstructor
public class MovimentoContrato extends MovimentoFinanceiro implements BaseEntity, Serializable {
	public MovimentoContrato(String tipomovimento) {
		super(tipomovimento);
	}

	public MovimentoContrato(int id,int parcelas) {
		super(id, parcelas);
	}

	private static final long serialVersionUID = 1L;
	
	
}
