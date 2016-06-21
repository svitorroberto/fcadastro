package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Cliente;

public class ClienteDaoImpl implements ClienteDao{

	//Com entityManager	
			protected EntityManager entityManager;
			 
		    public ClienteDaoImpl() {
		        entityManager = getEntityManager();
		    }
			
			private EntityManager getEntityManager() {
		        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CadastroCeasa");
		        if (entityManager == null) {
		            entityManager = factory.createEntityManager();
		        }
		 
		        return entityManager;
		    }
			
			
	public void inserir(Cliente c) {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
		
	}

	public Cliente getUsuario(String cnpj, String senha) {
		 try {
             Cliente cliente = (Cliente) entityManager
                        .createQuery(
                                    "SELECT c from Cliente c where c.cl_cnpj = :cl_cnpj and c.senha = :senha")
                        .setParameter("cl_cnpj", cnpj)
                        .setParameter("senha", senha).getSingleResult();

             return cliente;
       } catch (NoResultException e) {
             return null;
       }
 
	}

	public boolean deletar(Cliente c) {
		 try {
             entityManager.remove(c);
             return true;
       } catch (Exception e) {
             e.printStackTrace();
             return false;
       }
		
	}
	
	
	
}
