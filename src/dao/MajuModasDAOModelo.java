package dao;

import java.util.List;

import model.Modelo;

public interface MajuModasDAOModelo {

	
	public void adicionar(Modelo modelo);
	public void remover(Modelo modelo, Integer codigoAviamento);
	public void alterar(Modelo modelo);
	public List<Modelo> buscarModelo();
	public List<Modelo> buscarModeloInfoBasica();
	
	
}
