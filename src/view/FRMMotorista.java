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

import model.Motorista;
import controller.ControleMotorista;

public class FRMMotorista extends JPanel implements ActionListener{
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtPlaca;
	private ControleMotorista ctrlMotorista = new ControleMotorista();
	private String numPlaca;
	private JButton btnPesquisar, btnCancelar, btnAlterar, btnSalvar;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMMotorista() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setForeground(Color.BLACK);
		lblMotorista.setBackground(Color.WHITE);
		lblMotorista.setBounds(12, 0, 202, 34);
		lblMotorista.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblMotorista);
		
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
		btnSalvar.setBounds(635, 547, 97, 25);
		add(btnSalvar);
		
		JLabel lblNumeroPlaca = new JLabel("N\u00FAmero da Placa");
		lblNumeroPlaca.setForeground(Color.BLACK);
		lblNumeroPlaca.setBackground(Color.WHITE);
		lblNumeroPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroPlaca.setBounds(12, 297, 134, 50);
		add(lblNumeroPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setForeground(Color.BLACK);
		txtPlaca.setBackground(Color.WHITE);
		txtPlaca.setBounds(158, 312, 171, 22);
		add(txtPlaca);
		txtPlaca.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(292, 547, 97, 25);
		add(btnCancelar);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(360, 99, 89, 23);
		add(btnPesquisar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(470, 548, 97, 25);
		add(btnAlterar);

		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnAlterar.setEnabled(false);
	}
	
	private Motorista dadosMotorista() {
		Motorista motorista = new Motorista();
		motorista.setNome(txtNome.getText());
		String fone;
		try {
			fone = txtFone.getText(1,3) + txtFone.getText(5,5) + txtFone.getText(11,4);
			motorista.setTelefoneContato(fone);
		} catch (BadLocationException e) {
			e.printStackTrace();
		} ;
		motorista.setNumPlaca(txtPlaca.getText());
		return motorista;
	}
	
	private void colocaTela(Motorista moto) {
		if(moto != null) {
			txtNome.setText(moto.getNome());
			txtFone.setText(moto.getTelefoneContato());
			txtPlaca.setText(moto.getNumPlaca());
		}
	}
	
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Salvar")) {
			try {
				ctrlMotorista.adicionarMotorista(dadosMotorista());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
			}
			limpaTela();
		}else if(a.getActionCommand().contains("Cancelar")) {
				limpaTela();
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
			}
		    if(a.getActionCommand().equals("Pesquisar")) {
		    	Motorista moto = new Motorista();
		    	moto.setNome(txtNome.getText());
		    	colocaTela(ctrlMotorista.buscar(moto));
		    	btnAlterar.setEnabled(true);
				btnSalvar.setEnabled(false);
		    }
		    if(a.getActionCommand().equals("Alterar")) {
		    	try {
		    		ctrlMotorista.alterar(dadosMotorista());
		    	} catch(Exception e) {
		    		JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
		    	}
		    	limpaTela();
		    }
	}
	
	private void limpaTela() {
		txtNome.setText("");
		txtFone.setText("");
		txtPlaca.setText("");
	}
}
