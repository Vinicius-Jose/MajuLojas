package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Modelagem;
import model.Modelo;

public class ControleModelagem implements ActionListener{
	private JTextField txtPrecoModelagem;
	private JComboBox<Modelo> cbModelo;
	private JFormattedTextField fttData;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnCancelar;
	
	private MajuModasDAO banco = new MajuModasDAOImpl();

	public ControleModelagem(JTextField txtPrecoModelagem, JComboBox<Modelo> cbModelo, JFormattedTextField fttData,
			JButton btnSalvar, JButton btnAlterar, JButton btnCancelar) {
		super();
		this.txtPrecoModelagem = txtPrecoModelagem;
		this.cbModelo = cbModelo;
		this.fttData = fttData;
		this.btnSalvar = btnSalvar;
		this.btnAlterar = btnAlterar;
		this.btnCancelar = btnCancelar;
	}
	
	public void adicionarModelagem(Modelagem modelagem) {
		banco.adicionar(modelagem);
		JOptionPane.showMessageDialog(null, "Modelagem adicionada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alterar(Modelagem modelagem) {
		banco.alterar(modelagem);
		JOptionPane.showMessageDialog(null, "Modelagem alterada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}



	@Override
	public void actionPerformed(ActionEvent a) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Modelagem modelagem = new Modelagem();
		if(cbModelo.getSelectedItem() != null) {
			modelagem = (Modelagem) cbModelo.getSelectedItem();
		}
		try {
			modelagem.setDataModelagem(new java.sql.Date(sdf.parse(fttData.getText()).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		modelagem.setValor(Float.parseFloat(txtPrecoModelagem.getText()));
		if(a.getActionCommand().equals("Salvar")) {
			adicionarModelagem(modelagem);
		}else
			if(a.getActionCommand().equals("Cancelar")) {
				cbModelo.setSelectedIndex(-1);
				fttData.setText(null);
				txtPrecoModelagem.setText("");	
			}
		    if(a.getActionCommand().equals("Alterar")) {
		    	alterar(modelagem);
		    }
		
	}

}

