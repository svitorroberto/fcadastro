package managedBean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ClienteDaoImpl;
import model.Cliente;

@ManagedBean(name="restaurarSenhaMB")
@SessionScoped
public class RestaurarSenhaMB {

	private static final long serialVersionUID = 6563545090037757690L;
	private Cliente c = new Cliente();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();

public String zerar() throws IOException, InterruptedException{
	
		c = clienteDao.getCliente(c.getCl_cnpj());
		if (c.getCl_razao().equals(null)) {
				addMessage("Empresa não encontrada");
			return null;
		} else {
			c.setCl_senha("");
			new ClienteDaoImpl().alterar(c);
			addMessage("Senha restaurada com sucesso!");
			System.out.println("RESTAUROU");
			c = new Cliente();
//			Thread.sleep(2000);
//			FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/Cadastro.jsf");
		return "zerou senha";
		}
	}


public void addMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
    FacesContext.getCurrentInstance().addMessage(null, message);
}

public Cliente getC() {
	return c;
}

public void setC(Cliente c) {
	this.c = c;
}
	

}

