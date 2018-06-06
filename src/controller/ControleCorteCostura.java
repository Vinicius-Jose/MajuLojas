package controller;

import java.util.List;

import model.CorteCostura;
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
}
