package view;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FRMGrade extends JPanel {
	private JTextField textField;
	private JTextField txtMin;
	private JTextField txtMax;

	/**
	 * Create the panel.
	 */
	public FRMGrade() {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Modelagem");
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 105, 56, 16);
		add(lblModelo);
		
		JComboBox cbModelo = new JComboBox();
		cbModelo.setBounds(80, 105, 352, 22);
		add(cbModelo);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrade.setBounds(12, 190, 56, 50);
		add(lblGrade);
		
		textField = new JTextField();
		textField.setBounds(80, 204, 42, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTamanho.setBounds(12, 281, 75, 50);
		add(lblTamanho);
		
		txtMin = new JTextField();
		txtMin.setBounds(112, 295, 42, 22);
		add(txtMin);
		txtMin.setColumns(10);
		
		txtMax = new JTextField();
		txtMax.setBounds(183, 295, 42, 22);
		add(txtMax);
		txtMax.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setBounds(166, 286, 29, 40);
		add(label);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(218, 547, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(496, 547, 97, 25);
		add(btnCancelar);
	}
}
