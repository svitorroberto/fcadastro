package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Func;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public class FuncDaoImpl implements FuncDao{

	//Com entityManager	
			protected EntityManager entityManager;
			 
		    public FuncDaoImpl() {
		        entityManager = getEntityManager();
		    }
			
			private EntityManager getEntityManager() {
		        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
		        if (entityManager == null) {
		            entityManager = factory.createEntityManager();
		        }
		 
		        return entityManager;
		    }
			
			
	public List<Func> listarFunc() {
		try {
			@SuppressWarnings("unchecked")
			List<Func> fs = (List<Func>) entityManager.createNativeQuery("select cl_cnpjcli, COUNT(*) as qot_func from tfiliado group by cl_cnpjcli order by qot_func desc").getResultList();
			return fs;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
