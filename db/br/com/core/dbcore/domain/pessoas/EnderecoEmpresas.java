package br.com.core.dbcore.domain.pessoas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.core.dbcore.domain.intefaces.BaseEnderecoInterface;
import br.com.core.dbcore.domain.intefaces.BaseEntity;

@Entity
public class EnderecoEmpresas implements Serializable, BaseEntity, BaseEnderecoInterface {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private String street;
	private String zipCode;
	private String bairro;
	private String city;
	private String nro;
	private String complement;
	private String state;
	private String descricao;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = " int ")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Empresas pessoas;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(columnDefinition = " int ")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Empresas empresa;

	public EnderecoEmpresas(String street, String zipCode, String bairro, String city, String nro, String complement,
			String state, String descricao, Empresas pessoas) {
		super();
		this.street = street;
		this.zipCode = zipCode;
		this.bairro = bairro;
		this.city = city;
		this.nro = nro;
		this.complement = complement;
		this.state = state;
		this.descricao = descricao;
		this.pessoas = pessoas;
	}

	public EnderecoEmpresas() {
		// TODO Auto-generated constructor stub
	}

	public EnderecoEmpresas(Empresas p) {
		super();
		this.street = p.getStreet();
		this.zipCode = p.getZipCode();
		this.bairro = p.getBairro();
		this.city = p.getCity();
		this.nro = p.getNro();
		this.complement = p.getComplement();
		this.state = p.getState();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		EnderecoEmpresas other = (EnderecoEmpresas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Empresas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Empresas pessoas) {
		this.pessoas = pessoas;
	}

	 

	 
	@Override
	public void setPessoas(BaseEntity pessoas) {
		 this.pessoas=(Empresas) pessoas;
		
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

}
