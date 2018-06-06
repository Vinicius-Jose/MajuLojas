package controller;

import model.Motorista;
import dao.MajuModasDAO;

public class ControleMotorista {
	private MajuModasDAO banco;
	public void adicionarMotorista(Motorista motorista){
		banco.adicionar(motorista);
	}
	
	public Motorista buscar(Motorista motorista){
		return null;
	}
	
	public void alterar(Motorista motorista){
		banco.alterar(motorista);
	}
	
}
