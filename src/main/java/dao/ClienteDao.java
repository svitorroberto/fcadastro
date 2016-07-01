package dao;

import model.Cliente;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public interface ClienteDao {

	public void inserir(Cliente c);
	public Cliente getUsuario(String cnpj, String senha);
	public boolean deletar(Cliente c);
	public void alterar(Cliente c);
	
}
