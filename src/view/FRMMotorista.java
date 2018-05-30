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

public class FRMMotorista extends JPanel {
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtPlaca;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMMotorista() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setBounds(12, 0, 202, 34);
		lblMotorista.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblMotorista);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(127, 95, 202, 26);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(10, 95, 105, 26);
		add(lblNome);
		
		txtFone = new JFormattedTextField(new MaskFormatter("(###)#####-####"));
		txtFone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFone.setBounds(127, 208, 202, 22);
		add(txtFone);
		
		txtFone.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(12, 206, 72, 26);
		add(lblTelefone);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(635, 547, 97, 25);
		add(btnSalvar);
		
		JLabel lblNumeroPlaca = new JLabel("N\u00FAmero da Placa");
		lblNumeroPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroPlaca.setBounds(12, 297, 134, 50);
		add(lblNumeroPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(158, 312, 171, 22);
		add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setBounds(292, 547, 97, 25);
		add(btnCancelar);

	}
}
