package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;

import controller.ControleCliente;
import model.Cliente;

import java.awt.Color;

public class FRMCliente extends JPanel implements ActionListener {
	private JTextField txtNome;
	private JFormattedTextField txtFone;
	private ControleCliente ctrlCliente = new ControleCliente();
	private int id;
	private JButton btnAlterar,btnSalvar, btnCancelar, btnPesquisar;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMCliente() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.BLACK);
		lblCliente.setBackground(Color.WHITE);
		lblCliente.setBounds(12, 0, 224, 34);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblCliente);
		
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
		btnSalvar.setBounds(546, 547, 97, 25);
		add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(232, 547, 97, 25);
		add(btnCancelar);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(349, 95, 89, 23);
		add(btnPesquisar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(397, 548, 97, 25);
		add(btnAlterar);	
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnAlterar.setEnabled(false);
	}
	
	private Cliente dadosCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(txtNome.getText());
		try {
			String fone  = txtFone.getText(1,3) + txtFone.getText(5,5) + txtFone.getText(11,4); ;
			System.out.println(fone);
			cliente.setTelefoneContato(fone);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	private void colocaTela(Cliente cli) {
		if(cli != null) {
			txtNome.setText(cli.getNome());
			txtFone.setText(cli.getTelefoneContato());
			id = cli.getId();
			
		}else{
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Salvar")) {
			try {
				ctrlCliente.adicionarCliente(dadosCliente());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
			}
			limpaTela();
		}else 
			if(a.getActionCommand().equals("Cancelar")) {
			   limpaTela();
			   btnSalvar.setEnabled(true);
			   btnAlterar.setEnabled(false);
			}
			if(a.getActionCommand().equals("Pesquisar")) {
				btnAlterar.setEnabled(true);
				btnSalvar.setEnabled(false);
				Cliente cli = new Cliente();
				cli.setNome(txtNome.getText());
				cli = ctrlCliente.buscar(cli);
				
				colocaTela(cli);
			}
			if(a.getActionCommand().equals("Alterar")) {
				try {
					Cliente cliente = dadosCliente();
					System.out.println(id);
					cliente.setId(id);
					ctrlCliente.alterar(cliente);
					id = 0;
					btnAlterar.setEnabled(false);
					btnSalvar.setEnabled(true);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
				}
				limpaTela();
			}
	}
	
	private void limpaTela() {
		 txtNome.setText("");
		 txtFone.setText("");	
	}


	}

