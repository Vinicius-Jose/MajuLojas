package controller;

import model.Aviamento;
import model.Fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleAviamento implements ActionListener{
	private JTextField txtAviamento;
	private JTextField txtPreco;
	private JComboBox<Fornecedor> cbFornecedor ;
	private JFormattedTextField fttData;
	private JButton btnCancelar ;
	private JButton btnSalvar;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public ControleAviamento(JTextField txtAviamento, JTextField txtPreco, JComboBox<Fornecedor> cbFornecedor, JButton btnCancelar,
			JButton btnSalvar, JButton btnPesquisar, JButton btnAlterar) {
		super();
		this.txtAviamento = txtAviamento;
		this.txtPreco = txtPreco;
		this.cbFornecedor = cbFornecedor;
		this.btnCancelar = btnCancelar;
		this.btnSalvar = btnSalvar;
		this.btnPesquisar = btnPesquisar;
		this.btnAlterar = btnAlterar;
	}
	
	public void adicionarAviamento(Aviamento aviamento){
		banco.adicionar(aviamento);
		JOptionPane.showMessageDialog(null, "Aviamento adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	public Aviamento buscar(Aviamento aviamento){
		List<Aviamento> listaAviamento= banco.buscarAviamento();
		return (Aviamento) listaAviamento;
	}
	
	public void alterar(Aviamento aviamento){
		banco.alterar(aviamento);
		JOptionPane.showMessageDialog(null, "Aviamento alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Aviamento aviamento = new Aviamento();
		aviamento.setNome(txtAviamento.getText());
		aviamento.setValorCompra(Float.parseFloat(txtPreco.getText()));
		try {
			aviamento.setDataCompra((new java.sql.Date(sdf.parse(fttData.getText()).getTime())));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if(cbFornecedor.getSelectedItem() != null) {
			aviamento = (Aviamento) cbFornecedor.getSelectedItem();
		}
		if(a.getActionCommand().equals("Salvar")) {
			adicionarAviamento(aviamento);	
		}else
			if(a.getActionCommand().equals("Cancelar")) {
				cbFornecedor.getItemAt(-1);
				txtAviamento.setText("");
				txtPreco.setText("");
				fttData.setText(null);
		}else 
			if(a.getActionCommand().equals("Pesquisar")) {
				buscar(aviamento);
		    } 
			if(a.getActionCommand().equals("Alterar")) {
					alterar(aviamento);
			}
		}   
	}
	

