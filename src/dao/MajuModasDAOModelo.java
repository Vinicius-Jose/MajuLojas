/**
 * @autor Rodrigo Santos Santiago
 * Interface DAO Modelo
 */package dao;

import java.sql.SQLException;
import java.util.Set;

import model.Modelo;

public interface MajuModasDAOModelo {

	
	public void adicionar(Modelo modelo);
	public void remover(Modelo modelo, Integer codigoAviamento);
	public void alterar(Modelo modelo);
	public Set<Modelo> buscarModeloInfoBasica();
	int ultimoModelo() throws SQLException;
	
	
}
