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

import controller.ControleTecido;
import model.Fornecedor;

import javax.swing.JButton;
import java.awt.Color;

public class FRMTecido extends JPanel {
	private JTextField txtTecido;
	private JTextField txtPrecoUni;
	private JTextField txtValorTotal;
	private JTextField txtQtdRolo;
	private JComboBox<Fornecedor> cbFornecedor ;
	private JFormattedTextField fttData;
	private  JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMTecido() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Tecido");
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
		lblFornecedor.setBounds(12, 68, 119, 16);
		add(lblFornecedor);
		
		cbFornecedor = new JComboBox();
		cbFornecedor.setForeground(Color.BLACK);
		cbFornecedor.setBackground(Color.WHITE);
		cbFornecedor.setBounds(147, 68, 530, 23);
		add(cbFornecedor);
		
		txtTecido = new JTextField();
		txtTecido.setForeground(Color.BLACK);
		txtTecido.setBackground(Color.WHITE);
		txtTecido.setBounds(147, 143, 243, 22);
		add(txtTecido);
		txtTecido.setColumns(10);
		
		JLabel lblTipoDeTecido = new JLabel("Tipo de Tecido");
		lblTipoDeTecido.setForeground(Color.BLACK);
		lblTipoDeTecido.setBackground(Color.WHITE);
		lblTipoDeTecido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeTecido.setBounds(12, 145, 119, 16);
		add(lblTipoDeTecido);
		
		txtPrecoUni = new JTextField();
		txtPrecoUni.setForeground(Color.BLACK);
		txtPrecoUni.setBackground(Color.WHITE);
		txtPrecoUni.setBounds(147, 215, 116, 22);
		add(txtPrecoUni);
		txtPrecoUni.setColumns(10);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio");
		lblPreoUnitrio.setForeground(Color.BLACK);
		lblPreoUnitrio.setBackground(Color.WHITE);
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoUnitrio.setBounds(12, 217, 119, 16);
		add(lblPreoUnitrio);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setForeground(Color.BLACK);
		lblValorTotal.setBackground(Color.WHITE);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(12, 296, 90, 16);
		add(lblValorTotal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setForeground(Color.BLACK);
		txtValorTotal.setBackground(Color.WHITE);
		txtValorTotal.setBounds(147, 294, 116, 22);
		add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.BLACK);
		lblData.setBackground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(679, 146, 44, 16);
		add(lblData);
		
		fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setForeground(Color.BLACK);
		fttData.setBackground(Color.WHITE);
		fttData.setBounds(735, 143, 83, 22);
		add(fttData);
		
		txtQtdRolo = new JTextField();
		txtQtdRolo.setForeground(Color.BLACK);
		txtQtdRolo.setBackground(Color.WHITE);
		txtQtdRolo.setBounds(735, 216, 116, 22);
		add(txtQtdRolo);
		txtQtdRolo.setColumns(10);
		
		JLabel lblQuantidadeDeRolo = new JLabel("Quantidade de Rolo");
		lblQuantidadeDeRolo.setForeground(Color.BLACK);
		lblQuantidadeDeRolo.setBackground(Color.WHITE);
		lblQuantidadeDeRolo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeRolo.setBounds(562, 218, 161, 16);
		add(lblQuantidadeDeRolo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(594, 556, 97, 25);
		add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(273, 556, 97, 25);
		add(btnCancelar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(442, 557, 97, 25);
		add(btnAlterar);
		
		ControleTecido ctrlTecido = new ControleTecido(cbFornecedor, txtTecido, fttData, txtPrecoUni, txtQtdRolo, txtValorTotal, btnSalvar, btnCancelar, btnAlterar);
		cbFornecedor.addActionListener(ctrlTecido);
		btnSalvar.addActionListener(ctrlTecido);
		btnCancelar.addActionListener(ctrlTecido);
		btnAlterar.addActionListener(ctrlTecido);
	}

}
