package controller;

import model.Fornecedor;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleFornecedor {
	private MajuModasDAO banco = new MajuModasDAOImpl();
	public void adicionarfornecedor(Fornecedor fornecedor){
		banco.adicionar(fornecedor);
	}
	
	public Fornecedor buscar(Fornecedor fornecedor){
		return null;
	}
	
	public void alterar(Fornecedor fornecedor){
		banco.alterar(fornecedor);
	}
	
}
