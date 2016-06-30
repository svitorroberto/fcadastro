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
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexaoOracle");
	        if (entityManager == null) {
	            entityManager = factory.createEntityManager();
	        }
	 
	        return entityManager;
	    }
		
	public void inserir(Filiado f) {
		
		try {
			String f2 = String.valueOf(entityManager.createQuery("select max(cl_codigo) from Filiado").getSingleResult());
			int codigo = Integer.parseInt(f2)+1;
			System.out.println(codigo);
			f.setCl_codigo(Integer.toString(codigo));
		//	f.setCl_codigo("1400");
			entityManager.getTransaction().begin();
            entityManager.persist(f);
            entityManager.getTransaction().commit();
            System.out.println("CADASTROU");
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
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
