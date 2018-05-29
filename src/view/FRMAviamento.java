package view;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FRMAviamento extends JPanel {
	private JTextField txtAviamento;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FRMAviamento() {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Aviamento");
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFornecedor.setBounds(12, 79, 113, 16);
		add(lblFornecedor);
		
		JComboBox cbFornecedor = new JComboBox();
		cbFornecedor.setBounds(144, 79, 200, 22);
		add(cbFornecedor);
		
		JLabel lblAviamento_1 = new JLabel("Aviamento");
		lblAviamento_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAviamento_1.setBounds(12, 132, 113, 16);
		add(lblAviamento_1);
		
		txtAviamento = new JTextField();
		txtAviamento.setBounds(144, 130, 200, 22);
		add(txtAviamento);
		txtAviamento.setColumns(10);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoUnitrio.setBounds(12, 203, 107, 16);
		add(lblPreoUnitrio);
		
		textField = new JTextField();
		textField.setBounds(144, 201, 75, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(122, 348, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(312, 348, 97, 25);
		add(btnCancelar);
		
	}

}
