package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cargo;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
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
		return entityManager.createQuery("from Cargo order by ca_nome").getResultList();
	}

	public Cargo getCargo() {
		
		return null;
	}

}
