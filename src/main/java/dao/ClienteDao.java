package dao;

import model.Cliente;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
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
