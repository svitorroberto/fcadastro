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
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
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
	
	
	//RECUPERA OBJETO GRAVADO NA SESSÃO
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = (HttpSession) request.getSession();
	
	public CadastraFiliadoMB(){
//		System.out.println("CONSTRUTOR");
		f = new Filiado();
		c2 = (Cliente) session.getAttribute("CNPJ_EMPRESA");	
		f.setCl_cnpjcli(c2.getCl_cnpj());
		f.setCl_cliente(c2.getCl_razao());
	}
	
	public String criarFiliado() throws IOException{
		CNP cnp = new CNP();
		FiliadoDaoImpl fdi = new FiliadoDaoImpl();
//		System.out.println("CNPJ"+f.getCl_cnpjcli());
//		System.out.println("NOME"+f.getCl_cliente());
		if(cnp.tomarDecisao(f.getCl_cnpj())== false){
			addMessage("CPF/CNPJ do Funcionário Inválido");
			System.out.println("CPF/CNPJ do Funcionário Inválido");
		}
		else if (fdi.getQtdFiliado(f.getCl_cnpj())>0){
			FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/FuncAtencao.jsf");
			
			System.out.println("Funcionário já foi cadastrado.");
			
		}
		else if(filename.equals(null)){
			addMessage("Erro! tirar foto do funcionário");
		}
		else{
			transformaCodigos();
			new FiliadoDaoImpl().inserir(f);
			insereImagem();
			addMessage("Sucesso! Funcionário Cadastrado!");
			f = new Filiado();
			filename="";
			c2 = (Cliente) session.getAttribute("CNPJ_EMPRESA");	
			f.setCl_cnpjcli(c2.getCl_cnpj());
			f.setCl_cliente(c2.getCl_razao());
		}
		return "cnpj";
		
	}
	
	public String alterarFiliado() throws IOException{
		CNP cnp = new CNP();
		if(cnp.tomarDecisao(f.getCl_cnpj())== false){
			addMessage("CPF/CNPJ do Funcionário Inválido");
			System.out.println("CPF/CNPJ do Funcionário Inválido");
		}
		else if(filename.equals(null)){
			addMessage("Erro! tirar foto do funcionário");
		}
		else{
			transformaCodigos();
			String s = new FiliadoDaoImpl().alterar(f);
			insereImagem2(s);
			addMessage("Sucesso! Funcionário Alterado!");
			f = new Filiado();
			filename="";
			c2 = (Cliente) session.getAttribute("CNPJ_EMPRESA");	
			f.setCl_cnpjcli(c2.getCl_cnpj());
			f.setCl_cliente(c2.getCl_razao());
//			System.out.println("NÃO ERRO");
			FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/FuncAlterado.jsf");
			
		}
		return "cnpj";
		
	}
	
	//LUPA DO CADASTRO, BUSCA CEP NO BANCO E RETORNA VALORES
	public String procuraCep() throws IOException{
		CepDaoImpl cdi = new CepDaoImpl();
		Cep cep = cdi.getCep(f.getCl_cep());
		if(cep.equals(null)){
			FacesContext.getCurrentInstance().getExternalContext().redirect("/webCadastro/restrito/FuncAlterado.jsf");
			addMessage("Erro! CEP não encontrado");
		}
		else{
			
		f.setCl_cep(cep.getCep());
		f.setCl_enderec(cep.getDesc02());
		f.setCl_bairro(cep.getBai());
		f.setCl_complem(cep.getCompl());
		f.setCl_cidade(cep.getCid());
		f.setCl_estado(cep.getUf());
		f.setCl_pais("BRASIL");
		}
	
		
		return "cep";
	}
	
	//TRANSFORMA NOMES DE CIDADE/ESTADO/PAIS EM ID
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

	//GRAVA IMAGEM NO DIRETÓRIO
	private String getRandomImageName() {
            
        return session.getId();
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
    	img.setFi_codigo(f.getCl_codigo());
    	img.setFi_rg(f.getCl_rg());
//    	System.out.println(f.getCl_codigo());
    	Path path = Paths.get("D:"+File.separator+"img_filiado"+File.separator+"imagem"+File.separator+session.getId()+".jpg");
    	try {
			img.setFi_foto(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	ImagemDaoImpl idi = new ImagemDaoImpl();
    	idi.gravarImagem(img);
    }
    //FIM GRAVA IMAGEM
    
    public void insereImagem2(String s){
    	Imagem img = new Imagem();
    	img.setFi_codigo(f.getCl_codigo());
    	img.setFi_rg(f.getCl_rg());
//    	System.out.println(f.getCl_codigo());
    	Path path = Paths.get("D:"+File.separator+"img_filiado"+File.separator+"imagem"+File.separator+session.getId()+".jpg");
    	try {
			img.setFi_foto(Files.readAllBytes(path));
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
