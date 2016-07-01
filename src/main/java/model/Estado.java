package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
@Entity
@Table(name="tcadest0001")
public class Estado {
	
	@Id
	private String uf_codigo;
	private String uf_nome;
	private String uf_sigla;
	
	public String getUf_codigo() {
		return uf_codigo;
	}
	public void setUf_codigo(String uf_codigo) {
		this.uf_codigo = uf_codigo;
	}
	public String getUf_nome() {
		return uf_nome;
	}
	public void setUf_nome(String uf_nome) {
		this.uf_nome = uf_nome;
	}
	public String getUf_sigla() {
		return uf_sigla;
	}
	public void setUf_sigla(String uf_sigla) {
		this.uf_sigla = uf_sigla;
	}
	
	
}
