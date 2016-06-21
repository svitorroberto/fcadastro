package managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import dao.FiliadoDaoImpl;
import model.Filiado;

@ManagedBean(name="cadastraFiliado")
@SessionScoped
public class CadastraFiliadoMB implements Serializable{
	
	private static final long serialVersionUID = 6529685090067757690L;
	public Filiado f = new Filiado();
	public LoginMB login = new LoginMB();
	ServletRequest request;
	
	public String criarFiliado(){
		new FiliadoDaoImpl().inserir(f);
		f = new Filiado();
		addMessage("Funcionário Cadastrado com sucesso!");
		return "cnpj";
		
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Filiado getF() {
		return f;
	}

	public void setF(Filiado f) {
		this.f = f;
	}
	
	
	
}
