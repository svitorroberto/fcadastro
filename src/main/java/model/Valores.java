package model;

import dao.ClienteDaoImpl;

public class Valores {
	
	public static void main(String[] args){
		Cliente c = new Cliente();
		c.setCl_cnpj("99999999999999");
		c.setCl_codigo("1399");
		c.setCl_razao("Vitor S/A");
		c.setCl_senha("123");
		
		ClienteDaoImpl cdi = new ClienteDaoImpl();
		cdi.inserir(c);
		
		
	
	}

}
