package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.CorteCostura;
import model.Estoque;
import model.Grade;
import model.Modelo;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleCorteCostura implements ActionListener{
	private JTextField txtGrade;
	private JTextField txtQtd;
	private JTextField txtCorte;
	private JTextField txtCostura;
	private JFormattedTextField fttData;
	private JComboBox cbModelo;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnAtualizarEstoque;
	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	
	
	public ControleCorteCostura(JTextField txtGrade, JTextField txtQtd, JTextField txtCorte, JTextField txtCostura, 
	JFormattedTextField fttData, JComboBox cbModelo, JButton btnSalvar, JButton btnCancelar, JButton btnAtualizarEstoque, JButton btnAlterar) {
		super();
		this.txtGrade = txtGrade;
		this.txtQtd = txtQtd;
		this.txtCorte = txtCorte;
		this.txtCostura = txtCostura;
		this.fttData = fttData;
		this.cbModelo = cbModelo;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
		this.btnAtualizarEstoque = btnAtualizarEstoque;
		this.btnAlterar = btnAlterar;
	}

	public void adicionarCorteCostura(CorteCostura corteCostura){
		banco.adicionar(corteCostura);
		JOptionPane.showMessageDialog(null, "Corte & Costura adicionados com sucesso", "Ssucesso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public CorteCostura buscar(CorteCostura corteCostura){
		List<CorteCostura> listaCorteCostura = banco.buscarCorteCostura();
		return (CorteCostura) listaCorteCostura;
	}
	
	public void alterar(CorteCostura corteCostura){
		banco.alterar(corteCostura);
		JOptionPane.showMessageDialog(null, "Corte & Costura alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Modelo> buscarModelos(){
		List<Modelo> listaModelo = banco.buscarModelo();
		return listaModelo;
	}
	
	public void atualizarEstoque(Modelo modelo, String grade){
		Collator col = Collator.getInstance(new Locale ("pt", "BR"));
		Estoque b = null;
		for (Estoque a : modelo.getEstoque()) {
			if(col.compare(a.getGrade(), grade)>1){
				b = a;
			}
		 break;
		}
		banco.alterar(b);
		JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		CorteCostura corteCostura = new CorteCostura();
		Modelo modelo = new Modelo();
		if(cbModelo.getSelectedItem() != null) {
			modelo = (Modelo) cbModelo.getSelectedItem();
			corteCostura = (CorteCostura) cbModelo.getSelectedItem();
		}
	    String grade = txtGrade.getText();
		corteCostura.setQuantidadePecasCortadas(Integer.parseInt(txtQtd.getText()));
		corteCostura.setValorCorte(Float.parseFloat(txtCorte.getText()));
		corteCostura.setValorCostura(Float.parseFloat(txtCostura.getText()));
		if(a.getActionCommand().equals("Atualizar Estoque")) {
			atualizarEstoque(modelo, grade);
		}
		if(a.getActionCommand().equals("Salvar")) {
			adicionarCorteCostura(corteCostura);
		}else
			if (a.getActionCommand().equals("Cancelar")) {
			    txtQtd.setText("");
			    txtCorte.setText("");
			    txtCostura.setText("");
		    }
		    if(a.getActionCommand().equals("Pesquisar")) {
		    	buscar(corteCostura);
		    }
		    if(a.getActionCommand().equals("Alterar")) {
		    	alterar(corteCostura);
		    }
	}
}
