package view;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controller.ControleGrade;
import model.Grade;
import model.Modelo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FRMGrade extends JPanel implements ActionListener{
	private JComboBox cbModelo;
	private JTextField textField;
	private JTextField txtMin;
	private JTextField txtMax;
	private ControleGrade ctrlGrade = new ControleGrade();

	/**
	 * Create the panel.
	 */
	public FRMGrade() {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblAviamento = new JLabel("Grade");
		lblAviamento.setForeground(Color.BLACK);
		lblAviamento.setBackground(Color.WHITE);
		lblAviamento.setBounds(12, 0, 224, 34);
		lblAviamento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblAviamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 105, 56, 16);
		add(lblModelo);
		
		JComboBox cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(80, 105, 352, 22);
		add(cbModelo);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setForeground(Color.BLACK);
		lblGrade.setBackground(Color.WHITE);
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrade.setBounds(12, 190, 56, 50);
		add(lblGrade);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(80, 204, 42, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setForeground(Color.BLACK);
		lblTamanho.setBackground(Color.WHITE);
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTamanho.setBounds(12, 281, 75, 50);
		add(lblTamanho);
		
		txtMin = new JTextField();
		txtMin.setForeground(Color.BLACK);
		txtMin.setBackground(Color.WHITE);
		txtMin.setBounds(112, 295, 42, 22);
		add(txtMin);
		txtMin.setColumns(10);
		
		txtMax = new JTextField();
		txtMax.setForeground(Color.BLACK);
		txtMax.setBackground(Color.WHITE);
		txtMax.setBounds(183, 295, 42, 22);
		add(txtMax);
		txtMax.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setBounds(166, 286, 29, 40);
		add(label);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(530, 547, 97, 25);
		add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(238, 547, 97, 25);
		add(btnCancelar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(391, 548, 97, 25);
		add(btnAlterar);
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnAlterar.addActionListener(this);
		
		preencherCombo();
	
	}
	
	private void preencherCombo() {
		Set<Modelo> a = ctrlGrade.buscarModelo();
		cbModelo.removeAllItems();
		for(Modelo b : a) {
			cbModelo.addItem(b);
		}
	}
	
	private Grade dadosGrade() {
		Grade grade = new Grade();
		if(cbModelo.getSelectedItem() != null) {
			grade.setModelo((Modelo) cbModelo.getSelectedItem());
		}
		grade.setLetra(textField.getText());
		grade.setNumTamanhoMinimo(Integer.parseInt(txtMin.getText()));
		grade.setNumTamanhoMaximo(Integer.parseInt(txtMax.getText()));
		return grade;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Salvar")) {
			try {
				ctrlGrade.adicionarGrade(dadosGrade());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
			}
			limpaTela();
		}else
			if(a.getActionCommand().equals("Cancelar")) {
				limpaTela();
			}
		    if(a.getActionCommand().equals("Alterar")) {
		    	try {
		    		ctrlGrade.alterarGrade(dadosGrade());
		    	} catch(Exception e) {
		    		JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
		    	}
		    	limpaTela();
		    }
		
	}

	private void limpaTela() {
		cbModelo.setSelectedIndex(-1);
		textField.setText("");
		txtMin.setText("");
		txtMax.setText("");
	}
}
