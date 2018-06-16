/**
 * @autor Rodrigo Santos Santiago
 * Interface DAO Capital
 */
package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Capital;
import model.CorteCostura;
import model.Encomenda;
import model.Tecido;
import model.Venda;

public interface MajuModasDAOCapital {

	
	public void adicionar(Capital capital);
	public void remover(Capital capital);
	public void alterar(Capital capital);
	public List<Integer> buscaAnoCapital();
	public double buscarCapital(int mes, int ano);
	public List<HashMap<String, Object>> buscaDadosCapital(int mes, int ano);
	public boolean ultimoCapital();
	public int getMaxIdCapital();
	public Set<Encomenda> buscarEncomendas();
	public Set<Venda> buscarVenda();
	public Set<Tecido> buscarTecidos();
	public Set<CorteCostura> buscarCorte();
	public List<Integer> buscaMesesCapital();
	
}
