package br.com.core.dbcore.domain.agenda;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.core.dbcore.SimNaoConverter;
import br.com.core.dbcore.TipoEmailReportConverter;
import br.com.core.dbcore.domain.intefaces.BaseEntity;
import br.com.core.dbcore.domain.pessoas.Empresas;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class SendEmailFianaceiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(columnDefinition = " int")
	@JsonIgnore
	private Empresas empresa;

	@Convert(converter = SimNaoConverter.class)
	private String status;
	
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private Date datalancamento;
	
	@ElementCollection 
	@CollectionTable()
	private Set<String> emailsto=new    HashSet<>();

	@Convert(converter = TipoEmailReportConverter.class)
	private String  tipoemailreport;
}
