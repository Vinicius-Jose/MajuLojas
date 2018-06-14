package dao;

import java.util.List;

import model.Piloto;

public interface MajuModasDAOPiloto {

	
	public void adicionar(Piloto piloto);
	public void remover(Piloto piloto);
	public void alterar(Piloto piloto);
	public List<Piloto> buscarPiloto();
	Piloto buscarPilotoEspecifica(Piloto piloto);

	
}
