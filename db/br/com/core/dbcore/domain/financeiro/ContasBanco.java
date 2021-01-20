package br.com.core.dbcore.domain.financeiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.core.dbcore.domain.intefaces.BaseEntity;
import br.com.core.dbcore.domain.pessoas.Empresas;
import lombok.Data;

@Entity
@Data
public class ContasBanco implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String descricao;
	private String banco;
	private String agencia;
	private String conta;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contasBanco")
	private List<MovimentoBanco> movimentosBanco = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn
	private Empresas empresa;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private double saldo;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Transient
	private double saldoDevedor;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Transient
	private double saldoDisponive;

	public ContasBanco() {
		// TODO Auto-generated constructor stub
	}

 
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContasBanco other = (ContasBanco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BancoMovimento [banco=" + banco + "]";
	}

	 

}
