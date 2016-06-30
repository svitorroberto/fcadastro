package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tfiliado")
public class Filiado implements Serializable{
	
	@Id
	private String cl_codigo;
	private String cl_cnpj;
	private String cl_razao;
	private String cl_enderec;
	private String cl_bairro;
	private String cl_complem;
	private String cl_numero;
	private String cl_cep;
	private String cl_cidade;
	private String cl_estado;
	private String cl_pais;
	private String cl_fone1;
	private String cl_cliente;
	private String cl_cnpjcli;
	private String cl_sexo;
	
	private String cl_dtnascimento;
	private String cl_naturalidade;
	private String cl_materno;
	private String cl_paterno;
	private String cl_rg;
	private String cl_rgemissor;
	private String cl_email;
	private String cl_codgru;
	private String cl_dtadmissao;
	private String cl_cargo;
	
//	private String cl_carteira;


	public String getCl_codigo() {
		return cl_codigo;
	}
	public String getCl_sexo() {
		return cl_sexo;
	}
	public void setCl_sexo(String cl_sexo) {
		this.cl_sexo = cl_sexo;
	}
	public void setCl_codigo(String cl_codigo) {
		this.cl_codigo = cl_codigo;
	}
	public String getCl_razao() {
		return cl_razao;
	}
	public void setCl_razao(String cl_razao) {
		this.cl_razao = cl_razao.toUpperCase();
	}
	public String getCl_enderec() {
		return cl_enderec;
	}
	public void setCl_enderec(String cl_enderec) {
		this.cl_enderec = cl_enderec.toUpperCase();
	}
	public String getCl_bairro() {
		return cl_bairro;
	}
	public void setCl_bairro(String cl_bairro) {
		this.cl_bairro = cl_bairro.toUpperCase();
	}
	public String getCl_complem() {
		return cl_complem;
	}
	public void setCl_complem(String cl_complem) {
			this.cl_complem = cl_complem;
	}
	public String getCl_numero() {
		return cl_numero;
	}
	public void setCl_numero(String cl_numero) {
			this.cl_numero = cl_numero;
	}
	public String getCl_cep() {
		return cl_cep;
	}
	public void setCl_cep(String cl_cep) {
		String str = cl_cep.replaceAll("\\D+","");
		this.cl_cep = str;
	}
	public String getCl_cidade() {
		return cl_cidade;
	}
	public void setCl_cidade(String cl_cidade) {
		this.cl_cidade = cl_cidade.toUpperCase();
	}
	public String getCl_estado() {
		return cl_estado;
	}
	public void setCl_estado(String cl_estado) {
		this.cl_estado = cl_estado.toUpperCase();
	}
	public String getCl_pais() {
		return cl_pais;
	}
	public void setCl_pais(String cl_pais) {
		this.cl_pais = cl_pais.toUpperCase();
	}
	public String getCl_fone1() {
		return cl_fone1;
	}
	public void setCl_fone1(String cl_fone1) {
		this.cl_fone1 = cl_fone1;
	}
/*	public long getCl_cnpj() {
		return cl_cnpj;
	}
	public void setCl_cnpj(long cl_cnpj) {
		this.cl_cnpj = cl_cnpj;
	}
	public long getCl_cnpjcli() {
		return cl_cnpjcli;
	}
	public void setCl_cnpjcli(long cl_cnpjcli) {
		this.cl_cnpjcli = cl_cnpjcli;
	}
	
	public void setCl_cliente(long cl_cliente) {
		this.cl_cliente = cl_cliente;
	}
	public long getCl_cliente() {
		return cl_cliente;
	}
*/
	public String getCl_cnpj() {
		return cl_cnpj;
	}
	public void setCl_cnpj(String cl_cnpj) {
		String str = cl_cnpj.replaceAll("\\D+","");
		this.cl_cnpj = str;
	}
	public String getCl_cliente() {
		return cl_cliente;
	}
	public void setCl_cliente(String cl_cliente) {
		this.cl_cliente = cl_cliente;
	}
	public String getCl_cnpjcli() {
		return cl_cnpjcli;
	}
	public void setCl_cnpjcli(String cl_cnpjcli) {
		String str = cl_cnpjcli.replaceAll("\\D+","");
		this.cl_cnpjcli = str;
	}
	public String getCl_dtnascimento() {
		return cl_dtnascimento;
	}
	public void setCl_dtnascimento(String cl_dtnascimento) {
		this.cl_dtnascimento = cl_dtnascimento;
	}
	public String getCl_naturalidade() {
		return cl_naturalidade;
	}
	public void setCl_naturalidade(String cl_naturalidade) {
		this.cl_naturalidade = cl_naturalidade.toUpperCase();
	}
	public String getCl_materno() {
		return cl_materno;
	}
	public void setCl_materno(String cl_materno) {
		this.cl_materno = cl_materno.toUpperCase();
	}
	public String getCl_paterno() {
		return cl_paterno;
	}
	public void setCl_paterno(String cl_paterno) {
		this.cl_paterno = cl_paterno.toUpperCase();
	}
	public String getCl_rg() {
		return cl_rg;
	}
	public void setCl_rg(String cl_rg) {
		this.cl_rg = cl_rg;
	}
	public String getCl_rgemissor() {
		return cl_rgemissor;
	}
	public void setCl_rgemissor(String cl_rgemissor) {
		this.cl_rgemissor = cl_rgemissor.toUpperCase();
	}
	public String getCl_email() {
		return cl_email;
	}
	public void setCl_email(String cl_email) {
		this.cl_email = cl_email.toUpperCase();
	}
	public String getCl_codgru() {
		return cl_codgru;
	}
	public void setCl_codgru(String cl_codgru) {
		this.cl_codgru = cl_codgru;
	}
	public String getCl_dtadmissao() {
		return cl_dtadmissao;
	}
	public void setCl_dtadmissao(String cl_dtadmissao) {
		this.cl_dtadmissao = cl_dtadmissao;
	}
	public String getCl_cargo() {
		return cl_cargo;
	}
	public void setCl_cargo(String cl_cargo) {
		this.cl_cargo = cl_cargo;
	}
	
	@Override
	public String toString() {
		String s = getCl_dtadmissao()+" "+getCl_codigo()+" "+getCl_rgemissor()+" "+getCl_dtnascimento();
		return s;
	}

}
