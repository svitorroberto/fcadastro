package dao;

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
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
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
		//RECUPERA OBJETO GRAVADO NA SESSÃO
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = (HttpSession) request.getSession();
		
		Cliente c2 = (Cliente) session.getAttribute("CNPJ_EMPRESA");
		
	public void inserir(Filiado f) {
		
		try {
			String f2 = String.valueOf(entityManager.createQuery("select max(cl_codigo) from Filiado").getSingleResult());
			int codigo = Integer.parseInt(f2)+1;
			System.out.println(codigo);
			f.setCl_codigo(Integer.toString(codigo));
			entityManager.getTransaction().begin();
            entityManager.persist(f);
            entityManager.getTransaction().commit();
            System.out.println("["+c2.getCl_razao()+"]\tCADASTROU\t["+f.getCl_razao()+"]");
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
            System.out.println("["+c2.getCl_razao()+"]\tALTEROU\t["+f.getCl_razao()+"]");
            
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
	
	public int getQtdFiliado(String cnpj){
		try {
			List<Filiado> f = (List<Filiado>) entityManager.createQuery("SELECT f from Filiado f where f.cl_cnpj = :cl_cnpj").setParameter("cl_cnpj", cnpj).getResultList();
			return f.size(); 
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 0;
		
	}
	
	public static void main(String[] args){
		Filiado f = new Filiado();
		FiliadoDaoImpl fd = new FiliadoDaoImpl();
		f.setCl_razao("TESTANDO123 DA SILVA");
		f.setCl_cnpj("99999999999");
		f.setCl_cidade("1");
		f.setCl_estado("1");
		f.setCl_pais("1");
		f.setCl_cnpjcli("99999999999999");
		fd.inserir(f);
	}

}
