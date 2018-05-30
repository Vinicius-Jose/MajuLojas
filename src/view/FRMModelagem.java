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

public class FRMModelagem extends JPanel {
	private JTextField txtPrecoModelagem;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMModelagem() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblModelagem = new JLabel("Modelagem");
		lblModelagem.setBounds(12, 0, 224, 34);
		lblModelagem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblModelagem);
		
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
		
		txtPrecoModelagem = new JTextField();
		txtPrecoModelagem.setBounds(80, 210, 116, 22);
		add(txtPrecoModelagem);
		txtPrecoModelagem.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreo.setBounds(12, 212, 56, 16);
		add(lblPreo);
		
		JLabel lblDataDaModelagem = new JLabel("Data da Modelagem");
		lblDataDaModelagem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaModelagem.setBounds(494, 212, 169, 16);
		add(lblDataDaModelagem);
		
		JFormattedTextField fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setBounds(654, 210, 83, 22);
		add(fttData);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(531, 564, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(203, 564, 97, 25);
		add(btnCancelar);
		
		
	}

}
