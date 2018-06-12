package dao;

import java.util.List;

import model.CorteCostura;

public interface MajuModasDAOCorteCostura {

	
	public void adicionar(CorteCostura corteCostura);
	public void remover(CorteCostura corteCostura);
	public void alterar(CorteCostura corteCostura);
	public List<CorteCostura> buscarCorteCostura();
	
}
