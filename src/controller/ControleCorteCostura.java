package controller;

import java.text.Collator;
import java.util.List;
import java.util.Locale;

import model.CorteCostura;
import model.Estoque;
import model.Modelo;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleCorteCostura {
	private MajuModasDAO banco = new MajuModasDAOImpl();
	public void adicionarCorteCostura(CorteCostura corteCostura){
		banco.adicionar(corteCostura);
	}
	
	public CorteCostura buscar(CorteCostura corteCostura){
		return null;
	}
	
	public void alterar(CorteCostura corteCostura){
		banco.alterar(corteCostura);
	}
	
	public List<Modelo> buscarModelos(){
		return null;
	}
	
	public void atualizarEstoque(Modelo modelo, String grade){
		Collator col = Collator.getInstance(new Locale ("pt", "BR"));
		Estoque b = null;
		for (Estoque a : modelo.getEstoque()) {
			if(col.compare(a.getGrade(), grade)>1){
				b = a;
			}
		 break;
		}
		banco.alterar(b);
	}
}
