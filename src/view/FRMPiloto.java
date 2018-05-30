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

public class FRMPiloto extends JPanel {
	private JTextField txtPrecoPiloto;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMPiloto() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Piloto");
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 85, 56, 16);
		add(lblModelo);
		
		JComboBox cbModelo = new JComboBox();
		cbModelo.setBounds(80, 85, 352, 22);
		add(cbModelo);
		
		txtPrecoPiloto = new JTextField();
		txtPrecoPiloto.setBounds(80, 210, 116, 22);
		add(txtPrecoPiloto);
		txtPrecoPiloto.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreo.setBounds(12, 212, 56, 16);
		add(lblPreo);
		
		JLabel lblDataDoPiloto = new JLabel("Data do Piloto");
		lblDataDoPiloto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDoPiloto.setBounds(494, 212, 169, 16);
		add(lblDataDoPiloto);
		
		JFormattedTextField fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setBounds(654, 210, 83, 22);
		add(fttData);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(484, 554, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(155, 554, 97, 25);
		add(btnCancelar);
		
	}

}
