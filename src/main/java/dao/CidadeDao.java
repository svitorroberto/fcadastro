package dao;

import java.util.List;

import model.Cidade;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public interface CidadeDao {
	
	public Cidade getCidade(String cidade, String estado);
	public List<Cidade> listaCidades();
	

}
