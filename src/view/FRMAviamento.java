package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Aviamento;
import model.Fornecedor;
import controller.ControleAviamento;

public class FRMAviamento extends JPanel implements ActionListener {
	private JTextField txtAviamento;
	private JTextField txtPreco;
	private JComboBox cbFornecedor;
	private JButton btnCancelar;
	private JButton btnSalvar, btnPesquisar, btnAlterar;
	private JFormattedTextField fttData;
	private JFormattedTextField formattedTextField;
	private ControleAviamento ctrlAviamento = new ControleAviamento();
	private int id;

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
			fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
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

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(365, 131, 89, 23);
		add(btnPesquisar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(250, 349, 97, 25);
		btnAlterar.setEnabled(false);
		add(btnAlterar);

		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnPesquisar.addActionListener(this);

		preencherCombo();

	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Salvar")) {
			try {
				ctrlAviamento.adicionarAviamento(dadosAviamento());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Campos não preenchidos",
						"Preenchidos", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
			limpaTela();
		} else if (a.getActionCommand().equals("Cancelar")) {
			limpaTela();
			btnSalvar.setEnabled(true);
			btnAlterar.setEnabled(false);
		} else if (a.getActionCommand().equals("Pesquisar")) {
			Aviamento av = new Aviamento();
			btnAlterar.setEnabled(true);
			btnSalvar.setEnabled(false);
			av.setNome(txtAviamento.getText());
			colocaTela(ctrlAviamento.buscar(av));
		}
		if (a.getActionCommand().equals("Alterar")) {
			try {
				ctrlAviamento.alterar(dadosAviamento());
				btnAlterar.setEnabled(false);
				btnSalvar.setEnabled(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Campos não preenchidos",
						"Preenchidos", JOptionPane.INFORMATION_MESSAGE);
			}
			limpaTela();
		}

	}

	private void colocaTela(Aviamento av) {
		if (av != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			txtAviamento.setText(av.getNome());
			txtPreco.setText(Float.toString(av.getValorCompra()));
			cbFornecedor.setSelectedItem(av.getFornecedor());
			fttData.setText(sdf.format(av.getDataCompra()));
			txtAviamento.setText(av.getNome());
		}
	}

	private Aviamento dadosAviamento() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Aviamento aviamento = new Aviamento();
		aviamento.setNome(txtAviamento.getText());
		aviamento.setValorCompra(Float.parseFloat(txtPreco.getText()));
		try {
			aviamento.setDataCompra((new java.sql.Date(sdf.parse(
					fttData.getText()).getTime())));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (cbFornecedor.getSelectedItem() != null) {
			aviamento
					.setFornecedor((Fornecedor) cbFornecedor.getSelectedItem());
		}
		return aviamento;
	}

	private void preencherCombo() {
		List<Fornecedor> a = ctrlAviamento.buscarFornecedor();
		cbFornecedor.removeAllItems();
		for (Fornecedor b : a) {
			cbFornecedor.addItem(b);
		}
	}

	private void limpaTela() {
		cbFornecedor.getItemAt(-1);
		txtAviamento.setText("");
		txtPreco.setText("");
		fttData.setText(null);
	}

}
