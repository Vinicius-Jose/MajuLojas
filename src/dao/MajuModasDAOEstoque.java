package dao;

import java.util.HashMap;
import java.util.List;

import model.Estoque;
import model.Modelo;

public interface MajuModasDAOEstoque {

	public void adicionar(Estoque estoque);
	public void remover(Estoque estoque);
	public void alterar(Estoque estoque);
	public List<Estoque> buscarEstoque();
	public List<HashMap<String,Object>> buscarEspecifico(Modelo modelo);
	public List<Estoque> buscarEstoque(Modelo modelo);
	
}
