package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import java.awt.Color;

public class FRMMotorista extends JPanel {
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtPlaca;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMMotorista() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setForeground(Color.BLACK);
		lblMotorista.setBackground(Color.WHITE);
		lblMotorista.setBounds(12, 0, 202, 34);
		lblMotorista.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblMotorista);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.BLACK);
		txtNome.setBackground(Color.WHITE);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(127, 95, 202, 26);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBackground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(10, 95, 105, 26);
		add(lblNome);
		
		txtFone = new JFormattedTextField(new MaskFormatter("(###)#####-####"));
		txtFone.setForeground(Color.BLACK);
		txtFone.setBackground(Color.WHITE);
		txtFone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFone.setBounds(127, 208, 202, 22);
		add(txtFone);
		
		txtFone.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.BLACK);
		lblTelefone.setBackground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(12, 206, 72, 26);
		add(lblTelefone);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(635, 547, 97, 25);
		add(btnSalvar);
		
		JLabel lblNumeroPlaca = new JLabel("N\u00FAmero da Placa");
		lblNumeroPlaca.setForeground(Color.BLACK);
		lblNumeroPlaca.setBackground(Color.WHITE);
		lblNumeroPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroPlaca.setBounds(12, 297, 134, 50);
		add(lblNumeroPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setForeground(Color.BLACK);
		txtPlaca.setBackground(Color.WHITE);
		txtPlaca.setBounds(158, 312, 171, 22);
		add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(292, 547, 97, 25);
		add(btnCancelar);

	}
}
