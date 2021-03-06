/**
 * @autor Rodrigo Santos Santiago
 * Interface DAO Tecido
 */
package dao;

import java.util.List;

import model.Tecido;

public interface MajuModasDAOTecido {

	
	public void adicionar(Tecido tecido);
	public void remover(Tecido tecido);
	public void alterar(Tecido tecido);
	public List<Tecido> buscarTecido();
	Tecido buscarTecidoEspecifico(Tecido tecido);	
	
	
}
