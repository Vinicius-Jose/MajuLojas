/**
 * @autor Rodrigo Santos Santiago
 * Interface DAO Piloto
 */
package dao;

import java.util.List;

import model.Modelo;
import model.Piloto;

public interface MajuModasDAOPiloto {

	
	public void adicionar(Piloto piloto);
	public void remover(Piloto piloto);
	public void alterar(Piloto piloto);
	public List<Piloto> buscarPiloto();
	public Piloto buscarPilotoEspecifico(Modelo modelo);
	public int ultimoCadastroPiloto();

	
}
