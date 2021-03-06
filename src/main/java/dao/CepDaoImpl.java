package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

import model.Cep;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
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
			return c;
        } catch (NoResultException e) {
            e.printStackTrace();
        }catch (NonUniqueResultException n){
        	List<Cep> ceps = entityManager.createQuery("SELECT c from Cep c where c.cep = :cep").setParameter("cep", cep).getResultList();
        }
		return null;
	}

}
