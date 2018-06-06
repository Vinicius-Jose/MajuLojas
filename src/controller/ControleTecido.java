package controller;

import model.Tecido;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleTecido {
	private MajuModasDAO banco = new MajuModasDAOImpl();
	public void adicionarTecido(Tecido tecido){
		banco.adicionar(tecido);
	}
	
	public Tecido buscar(Tecido tecido){
		return null;
	}
	
	public void alterar(Tecido tecido){
		banco.alterar(tecido);
	}
	
}
