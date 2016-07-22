package dao;

import model.Filiado;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public interface FiliadoDao {
	
	public void inserir(Filiado f);
	public String alterar(Filiado f);

}
