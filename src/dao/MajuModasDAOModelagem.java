package dao;

import java.util.List;

import model.Modelagem;

public interface MajuModasDAOModelagem {

	
	public void adicionar(Modelagem modelagem);
	public void remover(Modelagem modelagem);
	public void alterar(Modelagem modelagem);
	public List<Modelagem> buscarModelagem();
	Modelagem buscarModelagemEspecifica(Modelagem modelagem);
	
	
}
