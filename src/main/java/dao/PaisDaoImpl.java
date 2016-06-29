package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pais;

public class PaisDaoImpl implements PaisDao{
	
	//Com entityManager	
			protected EntityManager entityManager;
			 
		    public PaisDaoImpl() {
		        entityManager = getEntityManager();
		    }
			
			private EntityManager getEntityManager() {
		        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
		        if (entityManager == null) {
		            entityManager = factory.createEntityManager();
		        }
		 
		        return entityManager;
		    }

	public Pais getPais(String nome) {
		try {
			Pais p = (Pais) entityManager.createQuery("SELECT p from Pais p where p.pa_nome = :pa_nome").setParameter("pa_nome", nome.toUpperCase()).getSingleResult();
			return p;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
