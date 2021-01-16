package br.com.core.apifinanceiro.dto.demonstrativo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.core.apifinanceiro.FaturaRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ReportDemostrativoFinancerio implements Serializable {

	private static final long serialVersionUID = 1L;

	 

	private int mes;

	private int exercicio;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO jan=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO fev=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO mar=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO abr=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO mai=new ItemMesDemostrativoDTO();
 

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO jun=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO jul=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO ago=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO set=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO out=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO nov=new ItemMesDemostrativoDTO();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ItemMesDemostrativoDTO dez=new ItemMesDemostrativoDTO();

	public ReportDemostrativoFinancerio(int mes, int exercicio) {
		super();
		this.mes = mes;
		this.exercicio = exercicio;
		
	}
	public ReportDemostrativoFinancerio(  int exercicio) {
		super(); 
		this.exercicio = exercicio;
		
		
	}
	
	

}
