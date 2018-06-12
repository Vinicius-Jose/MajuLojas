package dao;

import java.util.List;

import model.Fornecedor;

public interface MajuModasDAOFornecedor {

	
	public void adicionar(Fornecedor fornecedor);
	public void remover(Fornecedor fornecedor);
	public void alterar(Fornecedor fornecedor);
	public List<Fornecedor> buscarFornecedor();

	
}
