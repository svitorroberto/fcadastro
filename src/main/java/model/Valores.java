package model;

import dao.ClienteDaoImpl;

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
