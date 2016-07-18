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
@Table(name="tcadimgfiliado")
public class Imagem {
	
	private String ie_empresa;
	private String ie_filial;
	@Id
	private String ie_numero;
	private String ie_serie;
	private String ie_fornece;
	private String ie_tipoimg;
	
	private byte[] ie_imagem;
	
	public String getIe_numero() {
		return ie_numero;
	}
	public void setIe_numero(String ie_numero) {
		this.ie_numero = ie_numero;
	}
	
	public String getIe_fornece() {
		return ie_fornece;
	}
	public void setIe_fornece(String ie_fornece) {
		this.ie_fornece = ie_fornece;
	}
	public byte[] getIe_imagem() {
		return ie_imagem;
	}
	public void setIe_imagem(byte[] ie_imagem) {
		this.ie_imagem = ie_imagem;
	}
	public String getIe_empresa() {
		return ie_empresa;
	}
	public void setIe_empresa(String ie_empresa) {
		this.ie_empresa = ie_empresa;
	}
	public String getIe_filial() {
		return ie_filial;
	}
	public void setIe_filial(String ie_filial) {
		this.ie_filial = ie_filial;
	}
	public String getIe_serie() {
		return ie_serie;
	}
	public void setIe_serie(String ie_serie) {
		this.ie_serie = ie_serie;
	}
	public String getIe_tipoimg() {
		return ie_tipoimg;
	}
	public void setIe_tipoimg(String ie_tipoimg) {
		this.ie_tipoimg = ie_tipoimg;
	}
	
	

}
