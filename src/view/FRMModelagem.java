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

import controller.ControleModelagem;

import javax.swing.JButton;
import java.awt.Color;

public class FRMModelagem extends JPanel {
	private JTextField txtPrecoModelagem;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMModelagem() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblModelagem = new JLabel("Modelagem");
		lblModelagem.setForeground(Color.BLACK);
		lblModelagem.setBackground(Color.WHITE);
		lblModelagem.setBounds(12, 0, 224, 34);
		lblModelagem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblModelagem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 85, 56, 16);
		add(lblModelo);
		
		JComboBox cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(80, 85, 352, 22);
		add(cbModelo);
		
		txtPrecoModelagem = new JTextField();
		txtPrecoModelagem.setForeground(Color.BLACK);
		txtPrecoModelagem.setBackground(Color.WHITE);
		txtPrecoModelagem.setBounds(80, 210, 116, 22);
		add(txtPrecoModelagem);
		txtPrecoModelagem.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setForeground(Color.BLACK);
		lblPreo.setBackground(Color.WHITE);
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreo.setBounds(12, 212, 56, 16);
		add(lblPreo);
		
		JLabel lblDataDaModelagem = new JLabel("Data da Modelagem");
		lblDataDaModelagem.setForeground(Color.BLACK);
		lblDataDaModelagem.setBackground(Color.WHITE);
		lblDataDaModelagem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaModelagem.setBounds(494, 212, 169, 16);
		add(lblDataDaModelagem);
		
		JFormattedTextField fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setForeground(Color.BLACK);
		fttData.setBackground(Color.WHITE);
		fttData.setBounds(654, 210, 83, 22);
		add(fttData);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(531, 564, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(203, 564, 97, 25);
		add(btnCancelar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(370, 565, 97, 25);
		add(btnAlterar);
		
		ControleModelagem ctrlModelagem = new ControleModelagem(txtPrecoModelagem, cbModelo, fttData, btnSalvar, btnAlterar, btnCancelar);
		cbModelo.addActionListener(ctrlModelagem);
		btnSalvar.addActionListener(ctrlModelagem);
		btnAlterar.addActionListener(ctrlModelagem);
		btnCancelar.addActionListener(ctrlModelagem);
	}

}
