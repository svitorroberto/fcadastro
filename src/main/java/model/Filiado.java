package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tfiliado")
public class Filiado implements Serializable{
	
	@Id
	private String cl_cnpj;
	private String cl_razao;
	private String cl_enderec;
	private String cl_bairro;
	private String cl_complem;
	private String cl_num;
	private String cl_cep;
	private String cl_cidade;
	private String cl_estado;
	private String cl_pais;
	private String cl_fone1;
	private String cl_cliente;
	private String cl_cnpjcli;
	
	
	
	
	public String getCl_razao() {
		return cl_razao;
	}
	public void setCl_razao(String cl_razao) {
		this.cl_razao = cl_razao;
	}
	public String getCl_enderec() {
		return cl_enderec;
	}
	public void setCl_enderec(String cl_enderec) {
		this.cl_enderec = cl_enderec;
	}
	public String getCl_bairro() {
		return cl_bairro;
	}
	public void setCl_bairro(String cl_bairro) {
		this.cl_bairro = cl_bairro;
	}
	public String getCl_complem() {
		return cl_complem;
	}
	public void setCl_complem(String cl_complem) {
		this.cl_complem = cl_complem;
	}
	public String getCl_num() {
		return cl_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public String getCl_cep() {
		return cl_cep;
	}
	public void setCl_cep(String cl_cep) {
		this.cl_cep = cl_cep;
	}
	public String getCl_cidade() {
		return cl_cidade;
	}
	public void setCl_cidade(String cl_cidade) {
		this.cl_cidade = cl_cidade;
	}
	public String getCl_estado() {
		return cl_estado;
	}
	public void setCl_estado(String cl_estado) {
		this.cl_estado = cl_estado;
	}
	public String getCl_pais() {
		return cl_pais;
	}
	public void setCl_pais(String cl_pais) {
		this.cl_pais = cl_pais;
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
		this.cl_cnpj = cl_cnpj;
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
		this.cl_cnpjcli = cl_cnpjcli;
	}
	

}
