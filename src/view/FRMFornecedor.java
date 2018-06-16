/**
 * @autor Tela: Vinícius José; Métodos: Alicia Yoshida 
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;

import model.Fornecedor;
import controller.ControleFornecedor;

public class FRMFornecedor extends JPanel implements ActionListener {
	private JTextField txtNome;
	private JTextField txtFone;
	private ControleFornecedor ctrlFornecedor = new ControleFornecedor();
	private int id;
	private  JButton btnAlterar, btnSalvar, btnCancelar, btnPesquisar;

	/**
	 * Create the panel.
	 * 
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

		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(580, 547, 97, 25);
		add(btnSalvar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(247, 547, 97, 25);
		add(btnCancelar);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(355, 99, 89, 23);
		add(btnPesquisar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(420, 548, 97, 25);
		add(btnAlterar);

		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnAlterar.setEnabled(false);

	}

	private Fornecedor dadosFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(txtNome.getText());
		try {
			String fone = txtFone.getText(1, 3) + txtFone.getText(5, 5)
					+ txtFone.getText(11, 4);
			;
			System.out.println(fone);
			fornecedor.setTelefoneFornecedor(fone);
			fornecedor.setNome(txtNome.getText());
			fornecedor.setId(id);
			id = -1;
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return fornecedor;
	}

	private void colocaTela(Fornecedor forn) {
		if (forn != null) {
			txtNome.setText(forn.getNome());
			txtFone.setText(forn.getTelefoneFornecedor());
			id = forn.getId();
			btnAlterar.setEnabled(true);
			btnSalvar.setEnabled(false);
		}else {
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar o referido fornecedor",
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Salvar")) {
			try {
				ctrlFornecedor.adicionarfornecedor(dadosFornecedor());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Campos não preenchidos",
						"Preenchidos", JOptionPane.INFORMATION_MESSAGE);
			}
			limpaTela();
		} else if (a.getActionCommand().equals("Cancelar")) {
			limpaTela();
			btnSalvar.setEnabled(true);
			btnAlterar.setEnabled(false);
		}
		if (a.getActionCommand().equals("Pesquisar")) {
			
			Fornecedor forn = new Fornecedor();
			forn.setNome(txtNome.getText());
			colocaTela(ctrlFornecedor.buscar(forn));

		}

		if (a.getActionCommand().equals("Alterar")) {
			try {
				btnAlterar.setEnabled(false);
				btnSalvar.setEnabled(true);
				ctrlFornecedor.alterar(dadosFornecedor());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Impossível alterar fornecedor",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			limpaTela();
		}

	}

	private void limpaTela() {
		txtNome.setText("");
		txtFone.setText("");
	}

}
