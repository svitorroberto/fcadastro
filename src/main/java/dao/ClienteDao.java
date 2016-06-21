package dao;

import model.Cliente;

public interface ClienteDao {

	public void inserir(Cliente c);
	public Cliente getUsuario(String cnpj, String senha);
	public boolean deletar(Cliente c);
	
}
