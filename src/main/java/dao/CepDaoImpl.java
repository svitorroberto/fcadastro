package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Cep;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
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
