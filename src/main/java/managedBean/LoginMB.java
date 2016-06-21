package managedBean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ClienteDaoImpl;
import model.Cliente;

@ManagedBean(name="loginMB")
@SessionScoped
public class LoginMB implements Serializable{
	
	private static final long serialVersionUID = 6529685090037757690L;
	private Cliente c = new Cliente();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
	
	//True se usuário está logado e false caso contrário
	  private boolean loggedIn;
	   
	  //Armazena o usuário logado
	  private Cliente clienteLogado;
	  
	  
	
	public String doLogin() {
        
		c = clienteDao.getUsuario(c.getCl_cnpj(), c.getSenha());
        if (c == null) {
              c = new Cliente();
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuário não encontrado!","Erro no Login!"));
              FacesContext.getCurrentInstance().validationFailed();
              return "/Login.jsf?faces-redirect=true";
        } else {
        	setLoggedIn(true);
            setClienteLogado(c);
            return "/restrito/Cadastro.jsf?faces-redirect=true";
        }
        
        
  }

	//Realiza o logout do usuário logado
	  public String doLogout() throws IOException{
	    
	         setClienteLogado(null);
	         setLoggedIn(false);
	         FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/Login.jsf");
	   //    addInfoMessage("Logout realizado com sucesso !");
	         return "/Login.jsf?faces-redirect=true";
	  }
	
	
	
	

	public Cliente getC() {
		return c;
	}


	public void setC(Cliente c) {
		this.c = c;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Cliente getClienteLogado() {
		return clienteLogado;
	}

	public void setClienteLogado(Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
	}
	
	

}
