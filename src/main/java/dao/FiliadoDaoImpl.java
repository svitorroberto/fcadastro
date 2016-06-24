package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;
import model.Filiado;

public class FiliadoDaoImpl implements FiliadoDao{

	//Com entityManager	
		protected EntityManager entityManager;
		 
	    public FiliadoDaoImpl() {
	        entityManager = getEntityManager();
	    }
		
		private EntityManager getEntityManager() {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
	        if (entityManager == null) {
	            entityManager = factory.createEntityManager();
	        }
	 
	        return entityManager;
	    }
		
	public void inserir(Filiado f) {
		
		try {
			int codigo = entityManager.createQuery("select max(cl_codigo) from Cliente").getFirstResult();
			codigo=+1;
			f.setCl_codigo(Integer.toString(codigo));
		//	f.setCl_codigo("1400");
			entityManager.getTransaction().begin();
            entityManager.persist(f);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
	}

}
