package model;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public class Cliente2 {
	
	
	private String cl_cnpj;
	private String senha;
	private String senha2;
	

	public String getCl_cnpj() {
		return cl_cnpj;
	}
	public void setCl_cnpj(String cl_cnpj) {
		String str = cl_cnpj.replaceAll("\\D+","");
		this.cl_cnpj = str;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha2() {
		return senha2;
	}
	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	

}
