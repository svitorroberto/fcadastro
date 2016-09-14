package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.FuncDaoImpl;
import model.Func;

@ManagedBean(name="ListaFunc")
@ViewScoped
public class ListaFunc implements Serializable{

	private List<Func> func;

	public ListaFunc(){
		FuncDaoImpl fdi = new FuncDaoImpl();
        func = (List<Func>) fdi.listarFunc();
	}
	    
	
	
	public List<Func> getFunc() {
		return func;
	}

	public void setFunc(List<Func> func) {
		this.func = func;
	}
	
	
	
	
}
