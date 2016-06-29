package dao;

import java.util.List;

import model.Cidade;

public interface CidadeDao {
	
	public Cidade getCidade(String cidade, String estado);
	public List<Cidade> listaCidades();
	

}
