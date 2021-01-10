package br.com.core.apifinanceiro.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

import br.com.core.dbcore.domain.financeiro.movimento.Fatura;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FaturaDto {

	private Integer id;
	
	private String name;
	
	private String numerodocumento;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "dd/MM/yyyy")
	private Date dataVencimento;

	@NumberFormat(style = Style.DEFAULT, pattern = "0")
	private int parcela;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private double jurus;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private double multa;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private double desconto;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private double valor;
	
	private MultipartFile file;
	
	private Integer idbanco; 
	
	private String formapagamento;
	
	private String status;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "dd/MM/yyyy")
	private Date dataquitacao;

	public FaturaDto(Fatura f) {
		id=f.getId();
		name=f.getName();
		dataVencimento=f.getDataVencimento();
		parcela=f.getParcela();
		valor=f.getValor();
		status=f.getStatus();
		
	}
	
	
}
