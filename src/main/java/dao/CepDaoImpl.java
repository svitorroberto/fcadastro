package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Cep;

public class CepDaoImpl implements CepDao{

	//Com entityManager	
			protected EntityManager entityManager;
			 
		    public CepDaoImpl() {
		        entityManager = getEntityManager();
		    }
			
			private EntityManager getEntityManager() {
		        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
		        if (entityManager == null) {
		            entityManager = factory.createEntityManager();
		        }
		 
		        return entityManager;
		    }
			
	public Cep getCep(String cep) {
			Cep c = new Cep();
		try {
			c = (Cep) entityManager.createQuery("SELECT c from Cep c where c.cep = :cep").setParameter("cep", cep).getSingleResult();
			System.out.println(c.getCep());
			System.out.println(c.getCid());
			return c;
        } catch (NoResultException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            System.out.println("Cep retornou null");
            return null;
        }
	}

}
