package managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

import dao.CepDaoImpl;
import dao.CidadeDaoImpl;
import dao.ClienteDaoImpl;
import dao.EstadoDaoImpl;
import dao.FiliadoDaoImpl;
import dao.PaisDaoImpl;
import model.CNP;
import model.Cep;
import model.Cidade;
import model.Cliente;
import model.Estado;
import model.Filiado;
import model.Pais;

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
			transformaCodigos();
			new FiliadoDaoImpl().inserir(f);
			addMessage("Funcionário Cadastrado com sucesso!");
			System.out.println(f.toString());
			f = new Filiado();

			
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
		f.setCl_pais("BRASIL");
		System.out.println(f.getCl_estado());
		
		
		return "cep";
	}
	
	public void transformaCodigos(){
		Estado estado = new Estado();
		Cidade cidade = new Cidade();
		Pais pais = new Pais();
		Cliente c  = new Cliente();
		EstadoDaoImpl edi = new EstadoDaoImpl();
		CidadeDaoImpl cdi = new CidadeDaoImpl();
		PaisDaoImpl pdi = new PaisDaoImpl();
		ClienteDaoImpl clienteDao = new ClienteDaoImpl();
		
		estado = edi.getEstado(f.getCl_estado());
		f.setCl_estado(estado.getUf_codigo());
		cidade = cdi.getCidade(f.getCl_cidade(), f.getCl_estado());
		f.setCl_cidade(cidade.getCd_codigo());
		pais = pdi.getPais(f.getCl_pais());
		f.setCl_pais(pais.getPa_codigo());
		c = clienteDao.getCliente(f.getCl_cnpjcli());
		f.setCl_cliente(c.getCl_codigo());
		
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
