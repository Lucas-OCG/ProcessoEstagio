package br.com.ProcessoEstagio.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpfCnpj;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String localizacao;
	
	@NotEmpty
	private String sobre;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
}