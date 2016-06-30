package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cargo;

public class CargoDaoImpl implements CargoDao{

	//Com entityManager	
		protected EntityManager entityManager;
		 
	    public CargoDaoImpl() {
	        entityManager = getEntityManager();
	    }
		
		private EntityManager getEntityManager() {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
	        if (entityManager == null) {
	            entityManager = factory.createEntityManager();
	        }
	 
	        return entityManager;
	    }
		
	@SuppressWarnings("unchecked")
	public List<Cargo> listar() {
		return entityManager.createQuery("from Cargo").getResultList();
	}

	public Cargo getCargo() {
		
		return null;
	}

}
