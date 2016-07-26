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
@Table(name="TFOTOSFILIADO")
public class Imagem {
	@Id
	private String fi_codigo;
	private String fi_rg;
	private byte[] fi_foto;
	public String getFi_codigo() {
		return fi_codigo;
	}
	public void setFi_codigo(String fi_codigo) {
		this.fi_codigo = fi_codigo;
	}
	public String getFi_rg() {
		return fi_rg;
	}
	public void setFi_rg(String fi_rg) {
		this.fi_rg = fi_rg;
	}
	public byte[] getFi_foto() {
		return fi_foto;
	}
	public void setFi_foto(byte[] fi_foto) {
		this.fi_foto = fi_foto;
	}
	
//	private String ie_empresa;
//	private String ie_filial;
//	@Id
//	private String ie_numero;
//	private String ie_serie;
//	private String ie_fornece;
//	private String ie_tipoimg;
//	
//	private byte[] ie_imagem;
	
	
	
	

}
