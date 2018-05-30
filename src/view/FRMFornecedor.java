package view;

import java.awt.Component;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class FRMFornecedor extends JPanel {
	private JTextField txtNome;
	private JTextField txtFone;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMFornecedor() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(12, 0, 224, 34);
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblFornecedor);
		
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
		btnSalvar.setBounds(218, 547, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(496, 547, 97, 25);
		add(btnCancelar);
	}

}
