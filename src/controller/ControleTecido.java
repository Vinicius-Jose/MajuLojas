package controller;

import model.Fornecedor;
import model.Tecido;

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

public class ControleTecido implements ActionListener{
	private JComboBox<Fornecedor> cbFornecedor;
	private JTextField txtTecido;
	private JFormattedTextField fttData;
	private JTextField txtPrecoUni;
	private JTextField txtQtdRolo;
	private JTextField txtValorTotal;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	
	
	
	public ControleTecido(JComboBox<Fornecedor> cbFornecedor, JTextField txtTecido, JFormattedTextField fttData,
	JTextField txtPrecoUni, JTextField txtQtdRolo, JTextField txtValorTotal, JButton btnSalvar,
	JButton btnCancelar, JButton btnAlterar) {
		super();
		this.cbFornecedor = cbFornecedor;
		this.txtTecido = txtTecido;
		this.fttData = fttData;
		this.txtPrecoUni = txtPrecoUni;
		this.txtQtdRolo = txtQtdRolo;
		this.txtValorTotal = txtValorTotal;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
		this.btnAlterar = btnAlterar;
	}

	private MajuModasDAO banco = new MajuModasDAOImpl();
	public void adicionarTecido(Tecido tecido){
		banco.adicionar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Tecido buscar(Tecido tecido){
		List<Tecido> listaTecido = banco.buscarTecido();
		return (Tecido) listaTecido;
	}
	
	public void alterar(Tecido tecido){
		banco.alterar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Tecido tecido = new Tecido();
		if(cbFornecedor.getSelectedItem() != null) {
			tecido = (Tecido) cbFornecedor.getSelectedItem();
		}
		tecido.setTipo(txtTecido.getText());
		try {
			tecido.setData((new java.sql.Date(sdf.parse(fttData.getText()).getTime())));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		tecido.setValor(Float.parseFloat(txtPrecoUni.getText()));
		tecido.setQuantidade(Integer.parseInt(txtQtdRolo.getText()));
		float precoUnitario = Float.parseFloat(txtPrecoUni.getText());
		float qtdRolo = Integer.parseInt(txtQtdRolo.getText());
		float total = precoUnitario * qtdRolo;
		txtValorTotal.setText(String.valueOf(total));
		tecido.setValorTotal(Float.parseFloat(txtValorTotal.getText()));
		if(a.getActionCommand().equals("Salvar")) {
			adicionarTecido(tecido);
		}else
			if(a.getActionCommand().equals("Cancelar")) {
				cbFornecedor.setSelectedIndex(-1);
				fttData.setActionCommand(null);
				txtTecido.setText("");
				txtPrecoUni.setText("");
				txtQtdRolo.setText("");
				txtValorTotal.setText("");
			}
		    if(a.getActionCommand().equals("Alterar")) {
		    	alterar(tecido);
		    }
		
		
	}
	
}
