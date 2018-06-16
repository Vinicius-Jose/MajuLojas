/**
 * @autor Rodrigo Santos Santiago
 * Interface DAO Aviamento
 */
package dao;

import java.util.List;

import model.Aviamento;

public interface MajuModasDAOAviamento {
	
	public void adicionar(Aviamento aviamento);
	public void remover(Aviamento aviamento);
	public void alterar(Aviamento aviamento);
	public List<Aviamento> buscarAviamento();
	public Aviamento buscaEspecifico(Aviamento aviamento);
	
}
