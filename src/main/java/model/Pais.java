package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tcadpai0001")
public class Pais {
	
	@Id
	private String pa_codigo;
	private String pa_nome;
	
	public String getPa_codigo() {
		return pa_codigo;
	}
	public void setPa_codigo(String pa_codigo) {
		this.pa_codigo = pa_codigo;
	}
	public String getPa_nome() {
		return pa_nome;
	}
	public void setPa_nome(String pa_nome) {
		this.pa_nome = pa_nome;
	}
	
	

}
