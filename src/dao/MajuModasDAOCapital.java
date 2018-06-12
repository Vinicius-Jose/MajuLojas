package dao;

import java.util.List;

import model.Capital;

public interface MajuModasDAOCapital {

	
	public void adicionar(Capital capital);
	public void remover(Capital capital);
	public void alterar(Capital capital);
	public List<Capital> buscarCapital();
	
}
