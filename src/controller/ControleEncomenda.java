package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Cliente;
import model.Encomenda;
import model.Modelo;
import model.Motorista;

public class ControleEncomenda implements ActionListener{
	private JRadioButton rdbtnSim;
	private JRadioButton rdbtnNao;
	private JComboBox<Cliente> cbCliente;
	private JComboBox<Motorista> cbMotorista;
	private JFormattedTextField fttDataEncomenda;
	private JFormattedTextField fttDataRetirada;
	private JComboBox<Modelo> cbModelo;
	private JTextField txtQtdEncomendada;
	private JButton btnAdicionar;
	private JTable tabela;
	private JButton btnFinalizar;
	private JButton btnCancelar;
	
	

	public ControleEncomenda(JRadioButton rdbtnSim, JRadioButton rdbtnNao, JComboBox<Cliente> cbCliente,
			JComboBox<Motorista> cbMotorista, JFormattedTextField fttDataEncomenda, JFormattedTextField fttDataRetirada,
			JComboBox<Modelo> cbModelo, JTextField txtQtdEncomendada, JButton btnAdicionar, JTable tabela,
			JButton btnFinalizar, JButton btnCancelar) {
		super();
		this.rdbtnSim = rdbtnSim;
		this.rdbtnNao = rdbtnNao;
		this.cbCliente = cbCliente;
		this.cbMotorista = cbMotorista;
		this.fttDataEncomenda = fttDataEncomenda;
		this.fttDataRetirada = fttDataRetirada;
		this.cbModelo = cbModelo;
		this.txtQtdEncomendada = txtQtdEncomendada;
		this.btnAdicionar = btnAdicionar;
		this.tabela = tabela;
		this.btnFinalizar = btnFinalizar;
		this.btnCancelar = btnCancelar;
	}
	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public void finalizarEncomenda(Encomenda encomenda) {
		banco.adicionar(encomenda);
		JOptionPane.showMessageDialog(null, "Encomenda adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	



	@Override
	public void actionPerformed(ActionEvent a) {
		Encomenda encomenda = new Encomenda();
		if(rdbtnNao.isSelected()) {
			
		}
		
	}
	

}

