package model;

import java.io.Serializable;

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
@Table(name="tcadcli0001")
public class Cliente implements Serializable{
	
	@Id
	private String cl_codigo;
	private String cl_cnpj;
	private String cl_razao;
	private String cl_senha;
	private String ddelete;

	public String getCl_codigo() {
		return cl_codigo;
	}
	public void setCl_codigo(String cl_codigo) {
		this.cl_codigo = cl_codigo;
	}
	public String getCl_cnpj() {
		return cl_cnpj;
	}
	public void setCl_cnpj(String cl_cnpj) {
		String str = cl_cnpj.replaceAll("\\D+","");
		this.cl_cnpj = str;
	}
	public String getCl_razao() {
		return cl_razao;
	}
	public void setCl_razao(String cl_razao) {
		this.cl_razao = cl_razao;
	}
	public String getCl_senha() {
		return cl_senha;
	}
	public void setCl_senha(String cl_senha) {
		this.cl_senha = cl_senha;
	}
	public String getDdelete() {
		return ddelete;
	}
	public void setDdelete(String ddelete) {
		this.ddelete = ddelete;
	}

	
	
	

}
