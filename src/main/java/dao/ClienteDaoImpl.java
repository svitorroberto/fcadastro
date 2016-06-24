package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Cliente;

public class ClienteDaoImpl implements ClienteDao, Serializable{


	private static final long serialVersionUID = 1L;
	
			//Com entityManager	
			protected EntityManager entityManager;
			 
		    public ClienteDaoImpl() {
		        entityManager = getEntityManager();
		    }
			
			private EntityManager getEntityManager() {
		        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
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
		// RECEBE OBJETO E BUSCA SOMENTE PELO CNPJ
		Cliente c = getCliente(cnpj);
		//VEERIFICA SE RECEBEU ALGUM OBJETO
		if(c.getCl_cnpj()!=null){
			
			// SE O OBJETO ESTIVER SEM SENHA, ENTRA NO IF-ELSE
			if (c.getCl_senha()==null) {
				    //ELE COMPARA COM O PRÓPRIO CNPJ (PRIMEIRO LOGIN), SENDO VERDADEIRO, RETORNA O OBJETO
					if (cnpj.equals(senha)) {
						return c;
					} 
					// SE A SENHA NÃO BATER COM O PRÓPRIO CNPJ, RETORNA NULL
					else {
						return null;
					}
			} 
			// SE O OBJETO ESTIVER COM SENHA, ELE BUSCA NO BANCO POR CNPJ+SENHA
			else {
				try {
					c = (Cliente) entityManager.createQuery("SELECT c from Cliente c where c.cl_cnpj = :cl_cnpj and c.cl_senha = :cl_senha").setParameter("cl_cnpj", cnpj).setParameter("cl_senha", senha).getSingleResult();
					// SENDO VERDADEIRO, RETORNA O OBJETO
					return c;
				} catch (NoResultException e) {
				}

			}
			}
			// SE A SENHA NÃO BATER CNPJ+SENHA OU NÃO RECEBEU OBJETO, RETORNA NULL
			return null;
 
	}
	
	public Cliente getCliente(String cnpj) {
		 try {
            Cliente cliente = (Cliente) entityManager.createQuery("SELECT c from Cliente c where c.cl_cnpj = :cl_cnpj").setParameter("cl_cnpj", cnpj).getSingleResult();
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
	
	public void alterar(Cliente c){
		try {
            entityManager.getTransaction().begin();
            entityManager.merge(c);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
	}
	
	
	
}
