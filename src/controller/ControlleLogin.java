package controller;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControlleLogin {


	

	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public boolean verificarUsuario(String nome, String senha){
		boolean encontrado = banco.verificarUsuario(nome, senha);
		return encontrado;
	}


}
