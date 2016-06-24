package managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

import dao.CepDaoImpl;
import dao.FiliadoDaoImpl;
import model.CNP;
import model.Cep;
import model.Filiado;

@ManagedBean(name="cadastraFiliado")
@SessionScoped
public class CadastraFiliadoMB implements Serializable{
	
	private static final long serialVersionUID = 6529685090067757690L;
	public Filiado f = new Filiado();
	public LoginMB login = new LoginMB();
	ServletRequest request;
	
	public String criarFiliado(){
		CNP cnp = new CNP();
		if(cnp.tomarDecisao(f.getCl_cnpj())== false){
			addMessage("CPF/CNPJ do Funcionário Inválido");
		}
		else{
			
			new FiliadoDaoImpl().inserir(f);
			f = new Filiado();
			addMessage("Funcionário Cadastrado com sucesso!");
		}
		return "cnpj";
		
	}

	public String procuraCep(){
		CepDaoImpl cdi = new CepDaoImpl();
		Cep cep = cdi.getCep(f.getCl_cep());
		f.setCl_cep(cep.getCep());
		f.setCl_enderec(cep.getDesc02());
		f.setCl_bairro(cep.getBai());
		f.setCl_complem(cep.getCompl());
		f.setCl_cidade(cep.getCid());
		f.setCl_estado(cep.getUf());
		f.setCl_pais("Brasil");
		System.out.println(f.getCl_estado());
		
		
		return "cep";
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
