/**
 * @autor Rodrigo Santos Santiago
 * Interface DAO RelatorioLucro
 */
package dao;

import java.util.HashMap;
import java.util.List;

import model.RelatorioLucro;

public interface MajuModasDAORelatorioLucro {

	
	public void adicionar(RelatorioLucro lucro);
	public void remover(Integer codigoVenda);
	public void alterar(RelatorioLucro lucro);
	public int getMaxIdLucro();
	public List<HashMap<String, Object>> buscaDadosLucro(int mes, int ano);
	public double buscarLucro(int mes, int ano);


	
	
	
}
