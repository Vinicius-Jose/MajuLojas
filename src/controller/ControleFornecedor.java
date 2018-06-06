package controller;

import model.Fornecedor;
import dao.MajuModasDAO;

public class ControleFornecedor {
	private MajuModasDAO banco;
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
