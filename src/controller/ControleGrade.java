package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Grade;
import model.Modelo;

public class ControleGrade implements ActionListener{
	private JComboBox<Modelo> cbModelo;
	private JTextField txtGrade;
	private JTextField txtMin;
	private JTextField txtMax;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	
	

	public ControleGrade(JComboBox<Modelo> cbModelo, JTextField txtGrade, JTextField txtMin, JTextField txtMax,
	JButton btnSalvar, JButton btnCancelar, JButton btnAlterar) {
		super();
		this.cbModelo = cbModelo;
		this.txtGrade = txtGrade;
		this.txtMin = txtMin;
		this.txtMax = txtMax;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
		this.btnAlterar = btnAlterar;
	}
	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public void adicionarGrade(Grade grade) {
		banco.adicionar(grade);
		JOptionPane.showMessageDialog(null, "Grade adicionada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Grade buscarGrade() {
		List<Grade> listaGrade = banco.buscarGrade();
		return (Grade) listaGrade;
	}
	
	public void alterarGrade(Grade grade) {
		banco.alterar(grade);
		JOptionPane.showMessageDialog(null, "Grade alterada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Grade grade = new Grade();
		if(cbModelo.getSelectedItem() != null) {
			grade = (Grade) cbModelo.getSelectedItem();
		}
		grade.setLetra(txtGrade.getText());
		grade.setNumTamanhoMinimo(Integer.parseInt(txtMin.getText()));
		grade.setNumTamanhoMaximo(Integer.parseInt(txtMax.getText()));
		if(a.getActionCommand().equals("Salvar")) {
			adicionarGrade(grade);
		}else
			if(a.getActionCommand().equals("Cancelar")) {
				cbModelo.setSelectedIndex(-1);
				txtGrade.setText("");
				txtMin.setText("");
				txtMax.setText("");
			}
		    if(a.getActionCommand().equals("Alterar")) {
		    	alterarGrade(grade);
		    }
		
	}
	

}
