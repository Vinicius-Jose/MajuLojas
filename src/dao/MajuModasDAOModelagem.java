package dao;

import java.util.List;

import model.Modelagem;
import model.Modelo;

public interface MajuModasDAOModelagem {

	
	public void adicionar(Modelagem modelagem);
	public void remover(Modelagem modelagem);
	public void alterar(Modelagem modelagem);
	public List<Modelagem> buscarModelagem();
	public Modelagem buscarModelagemEspecifica(Modelo modelo);
	public int ultimoCadastroModelagem();
	
	
}
