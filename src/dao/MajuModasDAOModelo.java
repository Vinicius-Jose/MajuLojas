package dao;

import java.util.List;
import java.util.Set;

import model.Modelo;

public interface MajuModasDAOModelo {

	
	public void adicionar(Modelo modelo);
	public void remover(Modelo modelo, Integer codigoAviamento);
	public void alterar(Modelo modelo);
	public Set<Modelo> buscarModeloInfoBasica();
	
	
}
