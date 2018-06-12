package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Cliente;

public class ControleCliente implements ActionListener{
	private JTextField txtNome;
	private JTextField txtFone;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	
	public ControleCliente(JTextField txtNome, JTextField txtFone, JButton btnSalvar, JButton btnCancelar, JButton btnPesquisar, JButton btnAlterar) {
		super();
		this.txtNome = txtNome;
		this.txtFone = txtFone;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
		this.btnPesquisar = btnPesquisar;
		this.btnAlterar = btnAlterar;
	}
	
	public void adicionarCliente(Cliente cliente){
		banco.adicionar(cliente);
		JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Cliente buscar(Cliente cliente){
		List<Cliente> listaCliente = banco.buscarCliente();
		return (Cliente) listaCliente;
	}
	
	public void alterar(Cliente cliente){
		banco.alterar(cliente);
		JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Cliente cliente = new Cliente();
		cliente.setNome(txtNome.getText());
		cliente.setTelefoneContato(txtFone.getText());
		if(a.getActionCommand().equals("Salvar")) {
				adicionarCliente(cliente);	
		}else 
			if(a.getActionCommand().equals("Cancelar")) {
			   txtNome.setText("");
			   txtFone.setText("");	
			}
			if(a.getActionCommand().equals("Pesquisar")) {
				buscar(cliente);
			}
			if(a.getActionCommand().equals("Alterar")) {
				alterar(cliente);
			}
		
	}
	
}
