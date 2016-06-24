package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cep")
public class Cep {
	
	@Id
	private String cep;
	private String desc02;
	private String bai;
	private String compl;
	private String cid;
	private String uf;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getDesc02() {
		return desc02;
	}
	public void setDesc02(String desc02) {
		this.desc02 = desc02;
	}
	public String getBai() {
		return bai;
	}
	public void setBai(String bai) {
		this.bai = bai;
	}
	public String getCompl() {
		return compl;
	}
	public void setCompl(String compl) {
		this.compl = compl;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
}
