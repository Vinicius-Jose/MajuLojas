package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Estoque;
import model.Modelo;

public interface MajuModasDAOEstoque {

	public void adicionar(Estoque estoque, int idModelo);
	public void alterar(Estoque estoque, int idModelo);
	public void remover(Estoque estoque, int idModelo);
	public List<Estoque> buscarEstoque();
	public List<HashMap<String,Object>> buscarEspecifico(Modelo modelo);
	public Set<Estoque> buscarEstoque(Modelo modelo);


	
}
