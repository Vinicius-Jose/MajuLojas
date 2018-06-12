package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControlleLogin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem-Vindo!");
		lblBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblBemVindo.setBounds(151, 25, 138, 48);
		contentPane.add(lblBemVindo);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(151, 103, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(83, 106, 56, 16);
		contentPane.add(lblUsurio);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(151, 149, 116, 22);
		contentPane.add(pswSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(83, 152, 56, 16);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(221, 197, 97, 25);
		contentPane.add(btnEntrar);
		
		ControlleLogin ctrlLogin = new ControlleLogin(txtUsuario, pswSenha, btnEntrar);
		btnEntrar.addActionListener(ctrlLogin);
	}

}
