package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Estado;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public class EstadoDaoImpl implements EstadoDao{
	
	//Com entityManager	
			protected EntityManager entityManager;
			 
		    public EstadoDaoImpl() {
		        entityManager = getEntityManager();
		    }
			
			private EntityManager getEntityManager() {
		        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
		        if (entityManager == null) {
		            entityManager = factory.createEntityManager();
		        }
		 
		        return entityManager;
		    }

	public Estado getEstado(String codUf) {
		try {
			Estado e = (Estado) entityManager.createQuery("SELECT e from Estado e where e.uf_sigla = :codUf").setParameter("codUf", codUf.toUpperCase()).getSingleResult();
			return e;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
