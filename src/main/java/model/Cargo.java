package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tcadcar0001")
public class Cargo {
	
	@Id
	private String ca_codigo;
	private String ca_nome;
	
	
	public String getCa_codigo() {
		return ca_codigo;
	}
	public void setCa_codigo(String ca_codigo) {
		this.ca_codigo = ca_codigo;
	}
	public String getCa_nome() {
		return ca_nome;
	}
	public void setCa_nome(String ca_nome) {
		this.ca_nome = ca_nome;
	}
	
	

}
