package controller;

import model.Aviamento;
import dao.MajuModasDAO;

public class ControleAviamento {
	private MajuModasDAO banco;
	public void adicionarAviamento(Aviamento aviamento){
		banco.adicionar(aviamento);
	}
	
	public Aviamento buscar(Aviamento aviamento){
		return null;
	}
	
	public void alterar(Aviamento aviamento){
		banco.alterar(aviamento);
	}
	
}
