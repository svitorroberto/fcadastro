package managedBean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ClienteDaoImpl;
import model.Cliente;
import model.Cliente2;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
@ManagedBean(name="trocarSenhaMB")
@SessionScoped
public class TrocarSenhaMB {
	
	private static final long serialVersionUID = 6567685090037757690L;
	private Cliente c = new Cliente();
	private Cliente2 c2 = new Cliente2();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
	
	
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = (HttpSession) request.getSession();
	
	public TrocarSenhaMB(){
		c = (Cliente) session.getAttribute("CNPJ_EMPRESA");	
		c2.setCl_cnpj(c.getCl_cnpj());
	}
	
	
	
	
	public String alterarCliente() throws InterruptedException, IOException{
		c = clienteDao.getCliente(c2.getCl_cnpj());
		
		if (c.getCl_razao().equals(null)) {
			addMessage("Empresa não encontrada");
		return null;
	} else {
	 	c.setCl_senha(c2.getSenha());
		new ClienteDaoImpl().alterar(c);
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
