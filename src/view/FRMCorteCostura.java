package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

public class FRMCorteCostura extends JPanel {
	private JTextField txtGrade;
	private JTextField txtQtd;
	private JTextField txtCorte;
	private JTextField txtCostura;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMCorteCostura() throws ParseException {
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblCorte = new JLabel("Corte & Costura");
		lblCorte.setBounds(12, 0, 224, 34);
		lblCorte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblCorte);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 80, 68, 20);
		add(lblModelo);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrade.setBounds(371, 81, 56, 16);
		add(lblGrade);
		
		txtGrade = new JTextField();
		txtGrade.setBounds(439, 78, 26, 22);
		add(txtGrade);
		txtGrade.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(70, 80, 235, 22);
		add(comboBox);
		
		JLabel lblQuantidadePeasCortadas = new JLabel("Quantidade Pe\u00E7as Cortadas");
		lblQuantidadePeasCortadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadePeasCortadas.setBounds(582, 82, 207, 16);
		add(lblQuantidadePeasCortadas);
		
		JFormattedTextField fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setBounds(629, 183, 83, 22);
		add(fttData);
		
		txtQtd = new JTextField();
		txtQtd.setBounds(801, 80, 41, 22);
		add(txtQtd);
		txtQtd.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(568, 185, 48, 16);
		add(lblData);
		
		txtCorte = new JTextField();
		txtCorte.setBounds(168, 180, 116, 22);
		add(txtCorte);
		txtCorte.setColumns(10);
		
		txtCostura = new JTextField();
		txtCostura.setBounds(168, 236, 116, 22);
		add(txtCostura);
		txtCostura.setColumns(10);
		
		JLabel lblPreoDoCorte = new JLabel("Pre\u00E7o do Corte");
		lblPreoDoCorte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoDoCorte.setBounds(12, 186, 148, 16);
		add(lblPreoDoCorte);
		
		JLabel lblPreoDaCostura = new JLabel("Pre\u00E7o da Costura");
		lblPreoDaCostura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoDaCostura.setBounds(12, 242, 148, 16);
		add(lblPreoDaCostura);
		
		JButton btnAtualizarEstoque = new JButton("Atualizar Estoque");
		btnAtualizarEstoque.setBounds(875, 79, 159, 25);
		add(btnAtualizarEstoque);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(350, 538, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(627, 538, 97, 25);
		add(btnCancelar);
		
	}

}
