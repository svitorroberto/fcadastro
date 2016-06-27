package managedBean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	
	
	
	public String alterarCliente() throws InterruptedException, IOException{
		c = clienteDao.getCliente(c2.getCl_cnpj());
		
		if (c.getCl_razao().equals(null)) {
			addMessage("Empresa não encontrada");
		return null;
	} else {
	 	c.setCl_senha(c2.getSenha());
		new ClienteDaoImpl().alterar(c);
		System.out.println("Gravou senha alterada");
		c = new Cliente();
		c2 = new Cliente2();		
		addMessage("Senha gravada com sucesso!");
		Thread.sleep(2000);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/Cadastro.jsf");
		return "cnpj";
	}
	}
	
	public void addMessage(String summary) {
	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	    FacesContext.getCurrentInstance().addMessage(null, message);
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
