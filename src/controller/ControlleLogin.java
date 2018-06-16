package controller;

import dao.MajuModasDAOImplVerificarUsuario;
import dao.MajuModasDAOVerificarUsuario;

public class ControlleLogin {


	

	private MajuModasDAOVerificarUsuario banco = new MajuModasDAOImplVerificarUsuario();
	
	public boolean verificarUsuario(String nome, String senha){
		boolean encontrado = banco.verificarUsuario(nome, senha);
		return encontrado;
	}


}
