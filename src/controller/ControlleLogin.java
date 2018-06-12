package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import view.TelaPrincipal;

public class ControlleLogin {


	

	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public boolean verificarUsuario(String nome, String senha){
		boolean encontrado = banco.verificarUsuario(nome, senha);
		return encontrado;
	}


}
