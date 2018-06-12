package dao;

import java.util.List;

import model.Encomenda;

public interface MajuModasDAOEncomenda {

	
	public void adicionar(Encomenda encomenda);
	public void remover(Encomenda encomenda, Integer codigoEncomenda);
	public void alterar(Encomenda encomenda);
	public List<Encomenda> buscarEncomenda();

	
}
