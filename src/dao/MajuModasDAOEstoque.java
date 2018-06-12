package dao;

import java.util.List;

import model.Estoque;

public interface MajuModasDAOEstoque {

	public void adicionar(Estoque estoque);
	public void remover(Estoque estoque);
	public void alterar(Estoque estoque);
	public List<Estoque> buscarEstoque();
	
	
}
