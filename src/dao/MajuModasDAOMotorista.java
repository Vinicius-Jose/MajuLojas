package dao;

import java.util.List;

import model.Motorista;

public interface MajuModasDAOMotorista {

	
	public void adicionar(Motorista motorista);
	public void remover(Motorista motorista);
	public void alterar(Motorista motorista);
	public List<Motorista> buscarMotorista();
	public Motorista buscarMotoristaEspecifico(Motorista motorista);
	
	
}
