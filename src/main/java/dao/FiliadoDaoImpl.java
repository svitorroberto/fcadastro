package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Filiado;

public class FiliadoDaoImpl implements FiliadoDao{

	//Com entityManager	
		protected EntityManager entityManager;
		 
	    public FiliadoDaoImpl() {
	        entityManager = getEntityManager();
	    }
		
		private EntityManager getEntityManager() {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CadastroCeasa");
	        if (entityManager == null) {
	            entityManager = factory.createEntityManager();
	        }
	 
	        return entityManager;
	    }
		
	public void inserir(Filiado f) {
		
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(f);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
	}

}
