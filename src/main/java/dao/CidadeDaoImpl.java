package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cidade;

public class CidadeDaoImpl implements CidadeDao{

	//Com entityManager	
			protected EntityManager entityManager;
			 
		    public CidadeDaoImpl() {
		        entityManager = getEntityManager();
		    }
			
			private EntityManager getEntityManager() {
		        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
		        if (entityManager == null) {
		            entityManager = factory.createEntityManager();
		        }
		 
		        return entityManager;
		    }

	public List<Cidade> listaCidades() {
			
		return null;
	}

	public Cidade getCidade(String cidade, String estado) {
		
		try {
			Cidade c = (Cidade) entityManager.createQuery("SELECT c from Cidade c where c.cd_nome = :cidade and c.cd_estado = :estado").setParameter("cidade", cidade.toUpperCase()).setParameter("estado", estado.toUpperCase()).getSingleResult();
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
