package controller;

import java.util.List;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

import model.Estoque;
import model.Modelo;

public class ControleEstoque {
	private MajuModasDAO banco = new MajuModasDAOImpl();
	public List<Modelo> buscarModelos(){
		return null;
	}
	
	public List<Estoque> buscarEstoque(Modelo modelo){
		return null;
	}
}
