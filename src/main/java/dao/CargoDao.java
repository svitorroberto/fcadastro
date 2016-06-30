package dao;

import java.util.List;

import model.Cargo;


public interface CargoDao {
	
	public Cargo getCargo();
	public List<Cargo> listar();
}
