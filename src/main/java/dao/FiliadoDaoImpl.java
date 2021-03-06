package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Filiado;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
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
		//RECUPERA OBJETO GRAVADO NA SESS�O
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = (HttpSession) request.getSession();
		
		Cliente c2 = (Cliente) session.getAttribute("CNPJ_EMPRESA");
		
	public void inserir(Filiado f) {
		
		try {
			String f2 = String.valueOf(entityManager.createQuery("select max(cl_codigo) from Filiado").getSingleResult());
			int codigo = Integer.parseInt(f2)+1;
//			entityManager.lock(f2, LockModeType.WRITE);
			f.setCl_codigo(Integer.toString(codigo));
			entityManager.getTransaction().begin();
            entityManager.persist(f);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
	}
	
public String alterar(Filiado f) {
		
		try {
			f.setCl_codigo(getFiliado2(f.getCl_cnpj(), f.getCl_cnpjcli()).getCl_codigo());
			entityManager.getTransaction().begin();
            entityManager.merge(f);
            entityManager.getTransaction().commit();
            
            return f.getCl_codigo();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
	}
	
	public Filiado getFiliado(String cnpj){
		try {
			return (Filiado) entityManager.createQuery("SELECT f from Filiado f where f.cl_cnpj = :cl_cnpj").setParameter("cl_cnpj", cnpj).getSingleResult();
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	public Filiado getFiliado2(String cnpj, String emp){
		try {
			return (Filiado) entityManager.createQuery("SELECT f from Filiado f where f.cl_cnpj = :cl_cnpj and f.cl_cnpjcli = :cl_cnpjcli").setParameter("cl_cnpj", cnpj).setParameter("cl_cnpjcli", emp).getSingleResult();
			 
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	
	public int getQtdFiliado(String cnpj, String emp){
		try {
			List<Filiado> f = (List<Filiado>) entityManager.createQuery("SELECT f from Filiado f where f.cl_cnpj = :cl_cnpj and f.cl_cnpjcli = :cl_cnpjcli").setParameter("cl_cnpj", cnpj).setParameter("cl_cnpjcli", emp).getResultList();
			return f.size(); 
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
		
	}
	
	
	
}
