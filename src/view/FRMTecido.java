package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

public class FRMTecido extends JPanel {
	private JTextField txtTecido;
	private JTextField txtPrecoUni;
	private JTextField txtValorTotal;
	private JTextField textField;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMTecido() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Tecido");
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFornecedor.setBounds(12, 68, 119, 16);
		add(lblFornecedor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(147, 68, 530, 23);
		add(comboBox);
		
		txtTecido = new JTextField();
		txtTecido.setBounds(147, 143, 243, 22);
		add(txtTecido);
		txtTecido.setColumns(10);
		
		JLabel lblTipoDeTecido = new JLabel("Tipo de Tecido");
		lblTipoDeTecido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeTecido.setBounds(12, 145, 119, 16);
		add(lblTipoDeTecido);
		
		txtPrecoUni = new JTextField();
		txtPrecoUni.setBounds(147, 215, 116, 22);
		add(txtPrecoUni);
		txtPrecoUni.setColumns(10);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoUnitrio.setBounds(12, 217, 119, 16);
		add(lblPreoUnitrio);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(12, 296, 90, 16);
		add(lblValorTotal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setBounds(147, 294, 116, 22);
		add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(679, 146, 44, 16);
		add(lblData);
		
		JFormattedTextField fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setBounds(735, 143, 83, 22);
		add(fttData);
		
		textField = new JTextField();
		textField.setBounds(735, 216, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidadeDeRolo = new JLabel("Quantidade de Rolo");
		lblQuantidadeDeRolo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeRolo.setBounds(562, 218, 161, 16);
		add(lblQuantidadeDeRolo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(594, 556, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(273, 556, 97, 25);
		add(btnCancelar);
	}

}
