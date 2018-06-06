package view;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class FRMAviamento extends JPanel {
	private JTextField txtAviamento;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FRMAviamento() {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Aviamento");
		lblAviamento.setForeground(Color.BLACK);
		lblAviamento.setBackground(Color.WHITE);
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setForeground(Color.BLACK);
		lblFornecedor.setBackground(Color.WHITE);
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFornecedor.setBounds(12, 79, 113, 16);
		add(lblFornecedor);
		
		JComboBox cbFornecedor = new JComboBox();
		cbFornecedor.setForeground(Color.BLACK);
		cbFornecedor.setBackground(Color.WHITE);
		cbFornecedor.setBounds(144, 79, 200, 22);
		add(cbFornecedor);
		
		JLabel lblAviamento_1 = new JLabel("Aviamento");
		lblAviamento_1.setForeground(Color.BLACK);
		lblAviamento_1.setBackground(Color.WHITE);
		lblAviamento_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAviamento_1.setBounds(12, 132, 113, 16);
		add(lblAviamento_1);
		
		txtAviamento = new JTextField();
		txtAviamento.setForeground(Color.BLACK);
		txtAviamento.setBackground(Color.WHITE);
		txtAviamento.setBounds(144, 130, 200, 22);
		add(txtAviamento);
		txtAviamento.setColumns(10);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblPreoUnitrio.setForeground(Color.BLACK);
		lblPreoUnitrio.setBackground(Color.WHITE);
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoUnitrio.setBounds(12, 203, 107, 16);
		add(lblPreoUnitrio);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(144, 201, 75, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(368, 348, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(122, 348, 97, 25);
		add(btnCancelar);
		
	}

}
