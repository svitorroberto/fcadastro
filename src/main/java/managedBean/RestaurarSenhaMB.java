package managedBean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
@ManagedBean(name="restaurarSenhaMB")
@SessionScoped
public class RestaurarSenhaMB {

	private static final long serialVersionUID = 6563545090037757690L;
	private Cliente c = new Cliente();
	private ClienteDaoImpl clienteDao = new ClienteDaoImpl();

public String zerar() throws IOException, InterruptedException{
	
		c = clienteDao.getCliente(c.getCl_cnpj());
		if (c.getCl_razao().equals(null)) {
				addMessage("Empresa n�o encontrada");
			return null;
		} else {
			c.setCl_senha("");
			new ClienteDaoImpl().alterar(c);
			addMessage("Senha restaurada com sucesso!");
			c = new Cliente();
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

