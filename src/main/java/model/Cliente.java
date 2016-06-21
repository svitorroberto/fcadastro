package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tcadcli0001")
public class Cliente implements Serializable{
	
	@Id
	private String cl_cnpj;
	private String cl_razao;
	private String senha;
	

	public String getCl_cnpj() {
		return cl_cnpj;
	}
	public void setCl_cnpj(String cl_cnpj) {
		this.cl_cnpj = cl_cnpj;
	}
	public String getCl_razao() {
		return cl_razao;
	}
	public void setCl_razao(String cl_razao) {
		this.cl_razao = cl_razao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
