package model;

import dao.ClienteDaoImpl;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public class Valores {
	
	public static void main(String[] args){
		Cliente c = new Cliente();
		c.setCl_cnpj("00000000000000");
		c.setCl_codigo("1404");
		c.setCl_razao("ADMINISTRADOR CEASA");
		
		ClienteDaoImpl cdi = new ClienteDaoImpl();
		cdi.inserir(c);
		
		
	
	}

}
