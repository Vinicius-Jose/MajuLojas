package controller;

import java.util.List;

import model.Aviamento;
import model.Modelo;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleModelo {
	private MajuModasDAO banco = new MajuModasDAOImpl();
	public void adicionarModelo(Modelo modelo){
		banco.adicionar(modelo);
	}
	
	public Modelo buscar(Modelo modelo){
		return null;
	}
	
	public void alterar(Modelo modelo){
		banco.alterar(modelo);
	}
	
	public List<Aviamento> buscarAviamentos(){
		return null;
	}
	
}
