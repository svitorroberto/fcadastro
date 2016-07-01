package dao;

import java.util.List;

import model.Cargo;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/

public interface CargoDao {
	
	public Cargo getCargo();
	public List<Cargo> listar();
}
