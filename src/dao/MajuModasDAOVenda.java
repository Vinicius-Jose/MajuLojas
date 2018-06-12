package dao;

import java.util.List;

import model.Venda;

public interface MajuModasDAOVenda {
	
	
	public void adicionar(Venda venda);
	public void remover(Venda venda);
	public void alterar(Venda venda);
	public List<Venda> buscarVenda();
	
}
