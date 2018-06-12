package view;

import java.awt.Component;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControleFornecedor;

import java.awt.Color;

public class FRMFornecedor extends JPanel {
	private JTextField txtNome;
	private JTextField txtFone;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMFornecedor() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setForeground(Color.BLACK);
		lblFornecedor.setBackground(Color.WHITE);
		lblFornecedor.setBounds(12, 0, 224, 34);
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblFornecedor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.BLACK);
		txtNome.setBackground(Color.WHITE);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(127, 95, 202, 26);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBackground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(10, 95, 105, 26);
		add(lblNome);
		
		txtFone = new JFormattedTextField(new MaskFormatter("(###)#####-####"));
		txtFone.setForeground(Color.BLACK);
		txtFone.setBackground(Color.WHITE);
		txtFone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFone.setBounds(127, 208, 202, 22);
		add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.BLACK);
		lblTelefone.setBackground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(12, 206, 72, 26);
		add(lblTelefone);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(580, 547, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(247, 547, 97, 25);
		add(btnCancelar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(355, 99, 89, 23);
		add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(420, 548, 97, 25);
		add(btnAlterar);
		
		ControleFornecedor ctrlFornecedor = new ControleFornecedor(txtNome, txtFone, btnSalvar, btnCancelar, btnPesquisar, btnAlterar);
		btnSalvar.addActionListener(ctrlFornecedor);
		btnCancelar.addActionListener(ctrlFornecedor);
		btnPesquisar.addActionListener(ctrlFornecedor);
		btnAlterar.addActionListener(ctrlFornecedor);

	}

}
