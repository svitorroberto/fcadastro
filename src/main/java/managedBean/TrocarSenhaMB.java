package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ClienteDaoImpl;
import model.Cliente;
import model.Cliente2;

@ManagedBean(name="trocarSenhaMB")
@SessionScoped
public class TrocarSenhaMB {
	
	private static final long serialVersionUID = 6567685090037757690L;
	private Cliente c = new Cliente();
	private Cliente2 c2 = new Cliente2();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
	
	
	public String alterarCliente(){
		c = clienteDao.getCliente(c.getCl_cnpj());
	 	c.setCl_senha(c2.getSenha());
		new ClienteDaoImpl().alterar(c);
		c = new Cliente();
		c2 = new Cliente2();		
		return "cnpj";
	}


	public Cliente2 getC2() {
		return c2;
	}


	public void setC2(Cliente2 c2) {
		this.c2 = c2;
	}


	public Cliente getC() {
		return c;
	}


	public void setC(Cliente c) {
		this.c = c;
	}
	
	
}
