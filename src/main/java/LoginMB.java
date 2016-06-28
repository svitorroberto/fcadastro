

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.ClienteDaoImpl;
import model.Cliente;

@ManagedBean(name="loginMB")
@SessionScoped
public class LoginMB implements Serializable{
	
	private static final long serialVersionUID = 6529685090037757690L;
	private Cliente c = new Cliente();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
	
	//True se usu�rio est� logado e false caso contr�rio
	  private boolean loggedIn;
	   
	  //Armazena o usu�rio logado
	  private Cliente clienteLogado;
	  
	  HttpSession session;
	  
	
	public String doLogin() {
        //PESQUISA SE H� ALGUM OBJETO COM A COMBINA��O CNPJ+SENHA
		c = clienteDao.getUsuario(c.getCl_cnpj(), c.getCl_senha());
        if (c == null) {
              c = new Cliente();
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Empresa n�o encontrada!","Erro no Login!"));
              FacesContext.getCurrentInstance().validationFailed();
              System.out.println("Empresa n�o encontrada");
              return "/Login.jsf?faces-redirect=true";
        } else if(c.getCl_senha()==null){
        	System.out.println("Senha n�o cadastrada");
        	setLoggedIn(true);
            setClienteLogado(c);
        	return "/restrito/AlterarSenha.jsf?faces-redirect=true";
        } else if(c.getCl_cnpj()=="99999999999999"){
        	System.out.println("Login OK");
        	setLoggedIn(true);
            setClienteLogado(c);
            return "/restrito/admin/RestaurarSenha.jsf?faces-redirect=true";
        }
        
        else {
        	System.out.println("Login OK");
        	setLoggedIn(true);
            setClienteLogado(c);
            return "/restrito/Cadastro.jsf?faces-redirect=true";
        }
        
        
  }

	
	

	//Realiza o logout do usu�rio logado
	  public String doLogout() throws IOException{
	    
	         setClienteLogado(null);
	         setLoggedIn(false);
	         FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/Login.jsf");
	   //    addInfoMessage("Logout realizado com sucesso !");
	         return "/Login.jsf?faces-redirect=true";
	  }
	
	public void teste(){
		System.out.println(c.getCl_cnpj());
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
