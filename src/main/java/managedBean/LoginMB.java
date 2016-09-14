package managedBean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.ClienteDaoImpl;
import model.Cliente;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
@ManagedBean(name="loginMB")
@SessionScoped
public class LoginMB implements Serializable{
	
	private static final long serialVersionUID = 6529685090037757690L;
	private Cliente c = new Cliente();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
	
	//GRAVAR OBJETO NA SESS�O
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
	
	//True se usu�rio est� logado e false caso contr�rio
	  private boolean loggedIn;
	   
	  //Armazena o usu�rio logado
	  private Cliente clienteLogado;
	  
	
	public String doLogin() throws IOException {
        //PESQUISA SE H� ALGUM OBJETO COM A COMBINA��O CNPJ+SENHA
		try{
			c = clienteDao.getUsuario(c.getCl_cnpj(), c.getCl_senha());
			session.setAttribute("CNPJ_EMPRESA", c);
		
		
        
        if(c.getCl_senha()==null){
        	setLoggedIn(true);
            setClienteLogado(c);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/AlterarSenha.jsf");
        	return "/restrito/AlterarSenha.jsf?faces-redirect=true";
        } else if(c.getCl_cnpj().equals("00000000000000")){
        	setLoggedIn(true);
            setClienteLogado(c);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/admin/RestaurarSenha.jsf");
            return "/restrito/admin/RestaurarSenha.jsf?faces-redirect=true";
        }
        else {
        	setLoggedIn(true);
            setClienteLogado(c);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/Cadastro.jsf");
            return "/restrito/Cadastro.jsf?faces-redirect=true";
        }
        
		}
		catch(NullPointerException e){
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Empresa n�o encontrada ou senha incorreta","Erro no Login!"));
			 return "Error";
		}
		
  }

	
	

	//Realiza o logout do usu�rio logado
	  public String doLogout() throws IOException{
		  	 
	         setClienteLogado(null);
	         setLoggedIn(false);
	         session.setAttribute("CNPJ_EMPRESA", null);
	         session.invalidate();
	         FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/Login.jsf");
	   //    addInfoMessage("Logout realizado com sucesso !");
	         return "/Login.jsf?faces-redirect=true";
	  }
	
	  public void voltar() throws IOException{
		    
	         FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/Cadastro.jsf");
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
