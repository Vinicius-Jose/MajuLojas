package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControlePiloto;

import java.awt.Color;

public class FRMPiloto extends JPanel {
	private JTextField txtPrecoPiloto;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMPiloto() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Piloto");
		lblAviamento.setForeground(Color.BLACK);
		lblAviamento.setBackground(Color.WHITE);
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
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
		
		txtPrecoPiloto = new JFormattedTextField(new MaskFormatter("####.##"));
		txtPrecoPiloto.setForeground(Color.BLACK);
		txtPrecoPiloto.setBackground(Color.WHITE);
		txtPrecoPiloto.setBounds(80, 210, 116, 22);
		add(txtPrecoPiloto);
		txtPrecoPiloto.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setForeground(Color.BLACK);
		lblPreo.setBackground(Color.WHITE);
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreo.setBounds(12, 212, 56, 16);
		add(lblPreo);
		
		JLabel lblDataDoPiloto = new JLabel("Data do Piloto");
		lblDataDoPiloto.setForeground(Color.BLACK);
		lblDataDoPiloto.setBackground(Color.WHITE);
		lblDataDoPiloto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDoPiloto.setBounds(494, 212, 169, 16);
		add(lblDataDoPiloto);
		
		JFormattedTextField fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setForeground(Color.BLACK);
		fttData.setBackground(Color.WHITE);
		fttData.setBounds(654, 210, 83, 22);
		add(fttData);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(484, 554, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(155, 554, 97, 25);
		add(btnCancelar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(327, 555, 97, 25);
		add(btnAlterar);
		
		ControlePiloto ctrlPiloto = new ControlePiloto(cbModelo, txtPrecoPiloto, fttData, btnSalvar, btnAlterar, btnCancelar);
		cbModelo.addActionListener(ctrlPiloto);
		btnSalvar.addActionListener(ctrlPiloto);
        btnAlterar.addActionListener(ctrlPiloto);
        btnCancelar.addActionListener(ctrlPiloto);
	}

}
