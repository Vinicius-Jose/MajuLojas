package controller;

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
import model.Modelo;
import model.Piloto;

public class ControlePiloto implements ActionListener{
	private JComboBox<Modelo> cbModelo;
	private JTextField txtPrecoPiloto;
	private JFormattedTextField fttData;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnCancelar;

	public ControlePiloto(JComboBox<Modelo> cbModelo, JTextField txtPrecoPiloto, JFormattedTextField fttData, JButton btnSalvar, 
			JButton btnAlterar, JButton btnCancelar) {
		super();
		this.cbModelo = cbModelo;
		this.txtPrecoPiloto = txtPrecoPiloto;
		this.fttData = fttData;
		this.btnAlterar = btnAlterar;
		this.btnCancelar = btnCancelar;
	}
	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public void adicionarPiloto(Piloto piloto) {
		banco.adicionar(piloto);
		JOptionPane.showMessageDialog(null, "Piloto adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Piloto buscarPiloto() {
		List<Piloto> listaPiloto = banco.buscarPiloto();
		return (Piloto) listaPiloto;
	}
	
	public void alterarPiloto(Piloto piloto) {
		banco.alterar(piloto);
		JOptionPane.showMessageDialog(null, "Piloto alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}



	@Override
	public void actionPerformed(ActionEvent a) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Piloto piloto = new Piloto();
		if(cbModelo.getSelectedItem() != null) {
			piloto = (Piloto) cbModelo.getSelectedItem();
		}
		piloto.setValorPiloto(Float.parseFloat(txtPrecoPiloto.getText()));
		try {
			piloto.setDataPiloto(new java.sql.Date(sdf.parse(fttData.getText()).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(a.getActionCommand().equals("Salvar")) {
			adicionarPiloto(piloto);
		}else
			if(a.getActionCommand().equals("Cancelar")) {
				cbModelo.setSelectedIndex(-1);
				txtPrecoPiloto.setText("");
				fttData.setText(null);
			}
		
	}

}

