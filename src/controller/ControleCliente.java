package controller;

import dao.MajuModasDAO;
import model.Cliente;

public class ControleCliente {
	private MajuModasDAO banco;
	public void adicionarCliente(Cliente cliente){
		banco.adicionar(cliente);
	}
	
	public Cliente buscar(Cliente cliente){
		return null;
	}
	
	public void alterar(Cliente cliente){
		banco.alterar(cliente);
	}
	
}
