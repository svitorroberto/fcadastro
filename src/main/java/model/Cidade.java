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
@Table(name="tcadcid0001")
public class Cidade {
	
	@Id
	private String cd_codigo;
	private String cd_estado;
	private String cd_nome;
	
	public String getCd_codigo() {
		return cd_codigo;
	}
	public void setCd_codigo(String cd_codigo) {
		this.cd_codigo = cd_codigo;
	}
	public String getCd_estado() {
		return cd_estado;
	}
	public void setCd_estado(String cd_estado) {
		this.cd_estado = cd_estado;
	}
	public String getCd_nome() {
		return cd_nome;
	}
	public void setCd_nome(String cd_nome) {
		this.cd_nome = cd_nome;
	}
	
	
}
