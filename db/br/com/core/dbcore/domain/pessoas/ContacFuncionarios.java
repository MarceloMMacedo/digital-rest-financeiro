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

import br.com.core.dbcore.domain.intefaces.BaseContactInterface;
import br.com.core.dbcore.domain.intefaces.BaseEntity;

@Entity
public class ContacFuncionarios implements BaseEntity, Serializable, BaseContactInterface {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String descricao;
	private String name;
	private String function;
	private String email;
	private String telefone;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Funcionarios pessoas;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn()
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Empresas empresa;
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		ContacFuncionarios other = (ContacFuncionarios) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Funcionarios getPessoas() {
		return pessoas;
	}

	public void setPessoas(Funcionarios pessoas) {
		this.pessoas = pessoas;
	}

	@Override
	public void setPessoas(BaseEntity pessoas) {
		this.pessoas = (Funcionarios) pessoas;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

}
