package controller;

import model.Fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleFornecedor implements ActionListener{
	private JTextField txtNome;
	private JTextField txtFone;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	
	public ControleFornecedor(JTextField txtNome, JTextField txtFone, JButton btnSalvar, JButton btnCancelar, JButton btnPesquisar, 
			JButton btnAlterar) {
		super();
		this.txtNome = txtNome;
		this.txtFone = txtFone;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
		this.btnPesquisar = btnPesquisar;
		this.btnAlterar = btnAlterar;
	}

	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public void adicionarfornecedor(Fornecedor fornecedor){
		banco.adicionar(fornecedor);
		JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Fornecedor buscar(Fornecedor fornecedor){
		List<Fornecedor> listaFornecedor = banco.buscarFornecedor();
		return (Fornecedor) listaFornecedor;
	}
	
	public void alterar(Fornecedor fornecedor){
		banco.alterar(fornecedor);
		JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(txtNome.getText());
		fornecedor.setTelefoneFornecedor(txtFone.getText());
		if(a.getActionCommand().equals("Salvar")) {
			adicionarfornecedor(fornecedor);
		}else
			if(a.getActionCommand().equals("Cancelar")) {
				txtNome.setText("");
				txtFone.setText("");
			}
		
	}
	
}
