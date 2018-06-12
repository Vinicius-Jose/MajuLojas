package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControleAviamento;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FRMAviamento extends JPanel {
	private JTextField txtAviamento;
	private JTextField txtPreco;
	private JComboBox cbFornecedor ;
	private JButton btnCancelar ;
	private JButton btnSalvar;
	private JFormattedTextField fttData;
	private JFormattedTextField formattedTextField;
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
		
		cbFornecedor = new JComboBox();
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
		
		txtPreco = new JTextField();
		txtPreco.setForeground(Color.BLACK);
		txtPreco.setBackground(Color.WHITE);
		txtPreco.setBounds(144, 201, 75, 22);
		add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(736, 108, 61, 14);
		add(lblData);
		
		try {
			fttData = new JFormattedTextField(
					new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fttData.setBounds(791, 106, 83, 22);
		add(fttData);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(368, 348, 97, 25);
		add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(122, 348, 97, 25);
		add(btnCancelar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(365, 131, 89, 23);
		add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(250, 349, 97, 25);
		add(btnAlterar);
		
		ControleAviamento ctrlAviamento = new ControleAviamento(txtAviamento, txtPreco, cbFornecedor, btnCancelar, btnSalvar,
		btnPesquisar, btnAlterar);
		cbFornecedor.addActionListener(ctrlAviamento);
		btnCancelar.addActionListener(ctrlAviamento);
		btnSalvar.addActionListener(ctrlAviamento);
		btnPesquisar.addActionListener(ctrlAviamento);
		btnAlterar.addActionListener(ctrlAviamento);
		
	}
}
