package controller;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Cliente;

public class ControleCliente {
	private MajuModasDAO banco = new MajuModasDAOImpl();
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
