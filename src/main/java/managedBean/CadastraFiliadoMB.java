package managedBean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.CaptureEvent;

import dao.CargoDaoImpl;
import dao.CepDaoImpl;
import dao.CidadeDaoImpl;
import dao.ClienteDaoImpl;
import dao.EstadoDaoImpl;
import dao.FiliadoDaoImpl;
import dao.ImagemDaoImpl;
import dao.PaisDaoImpl;
import model.CNP;
import model.Cargo;
import model.Cep;
import model.Cidade;
import model.Cliente;
import model.Estado;
import model.Filiado;
import model.Imagem;
import model.Pais;

/**
* O webCadastro � um programa que cadastra funcion�rios
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  V�tor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
@ManagedBean(name="cadastraFiliado")
@SessionScoped
public class CadastraFiliadoMB implements Serializable{
	
	private static final long serialVersionUID = 6529685090067757690L;
	public Filiado f;
	public LoginMB login = new LoginMB();
	Cliente c2 = new Cliente();
	private String filename;
	
	
	//RECUPERA OBJETO GRAVADO NA SESS�O
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = (HttpSession) request.getSession();
	
	public CadastraFiliadoMB(){
		System.out.println("CONSTRUTOR");
		f = new Filiado();
		c2 = (Cliente) session.getAttribute("CNPJ_EMPRESA");	
		f.setCl_cnpjcli(c2.getCl_cnpj());
		f.setCl_cliente(c2.getCl_razao());
	}
	
	
	
	
	
	public String criarFiliado(){
		CNP cnp = new CNP();
		FiliadoDaoImpl fdi = new FiliadoDaoImpl();
		System.out.println("CNPJ"+f.getCl_cnpjcli());
		System.out.println("NOME"+f.getCl_cliente());
		if(cnp.tomarDecisao(f.getCl_cnpj())== false){
			addMessage("CPF/CNPJ do Funcion�rio Inv�lido");
			System.out.println("CPF/CNPJ do Funcion�rio Inv�lido");
		}
		else if (fdi.getQtdFiliado(f.getCl_cnpj())>0){
			addMessage("Erro! funcion�rio j� foi cadastrado.");
			System.out.println("Erro! funcion�rio j� foi cadastrado.");
			System.out.println(fdi.getQtdFiliado(f.getCl_cnpj()));
		}
		else if(filename.equals(null)){
			addMessage("Erro! tirar foto do funcion�rio");
		}
		else{
			transformaCodigos();
			new FiliadoDaoImpl().inserir(f);
			insereImagem();
			addMessage("Sucesso! Funcion�rio Cadastrado!");
			f = new Filiado();
			filename="";
			c2 = (Cliente) session.getAttribute("CNPJ_EMPRESA");	
			f.setCl_cnpjcli(c2.getCl_cnpj());
			f.setCl_cliente(c2.getCl_razao());
			System.out.println("N�O ERRO");
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
	
	
	
	public List<Cargo> pegarCargos(){
		CargoDaoImpl cargos = new CargoDaoImpl();
		return cargos.listar();
	}
	
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	//GRAVA IMAGEM NO DIRET�RIO
	private String getRandomImageName() {
        int i = (int) (Math.random() * 100000000);
         
        return String.valueOf(i);
    }
 
    public String getFilename() {
        return filename;
    }
     
    public void oncapture(CaptureEvent captureEvent) {
        filename = getRandomImageName();
        byte[] data = captureEvent.getData();	
 
        
        String newFileName = "D:"+File.separator+"img_filiado"+File.separator+"imagem"+File.separator+filename+ ".jpg";
         
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);
//            imageOutput = new FileImageOutputStream(new File("./fotos//"+filename+ ".jpg"));
//            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        }
        catch(IOException e) {
            throw new FacesException("Error in writing captured image.", e);
        }
    }
    
    public void insereImagem(){
    	Imagem img = new Imagem();
    	img.setIe_empresa("0001");
    	img.setIe_filial("0001");
    	img.setIe_tipoimg("JPG");
    	img.setIe_serie("1");
    	img.setIe_fornece(f.getCl_codigo());
    	img.setIe_numero(f.getCl_codigo());
    	Path path = Paths.get("D:"+File.separator+"img_filiado"+File.separator+"imagem"+File.separator+filename+ ".jpg");
    	try {
			img.setIe_imagem(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	ImagemDaoImpl idi = new ImagemDaoImpl();
    	idi.gravarImagem(img);
    }
    //FIM GRAVA IMAGEM
    
	
	public Filiado getF() {
		return f;
	}

	public void setF(Filiado f) {
		this.f = f;
	}
	
	
	
}
