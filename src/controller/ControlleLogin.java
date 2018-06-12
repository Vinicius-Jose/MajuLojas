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

public class ControlleLogin implements ActionListener{
	private JTextField txtUsuario;
	private JPasswordField pswSenha;
	private JButton btnEntrar;

	public ControlleLogin(JTextField txtUsuario, JPasswordField pswSenha, JButton btnEntrar) {
		super();
		this.txtUsuario = txtUsuario;
		this.pswSenha = pswSenha;
		this.btnEntrar = btnEntrar;
	}

	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public boolean verificarUsuario(String nome, String senha){
		boolean encontrado = banco.verificarUsuario(nome, senha);
		return encontrado;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String usuario = txtUsuario.getText();
		String senha = pswSenha.getText();
		System.out.println(senha);
		if(a.getActionCommand().equals("Entrar")) {
			if(verificarUsuario(usuario, senha)) {
				TelaPrincipal principal = new TelaPrincipal();
			}else {
				JOptionPane.showMessageDialog(null, "Usuário Inválido/Senha Inválida","Inválido", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		
	}
}
