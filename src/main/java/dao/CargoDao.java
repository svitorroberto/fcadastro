package dao;

import java.util.List;

import model.Cargo;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/

public interface CargoDao {
	
	public Cargo getCargo();
	public List<Cargo> listar();
}
